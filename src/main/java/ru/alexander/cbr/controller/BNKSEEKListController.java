package ru.alexander.cbr.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.event.RowEditEvent;
import ru.alexander.cbr.model.BNKSEEK;
import ru.alexander.cbr.model.BnkseekFilter;
import ru.alexander.cbr.model.Pzn;
import ru.alexander.cbr.model.Reg;
import ru.alexander.cbr.model.Tnp;
import ru.alexander.cbr.model.UER;
import ru.alexander.cbr.repository.BNKSEEKRepository;
import ru.alexander.cbr.repository.PznRepository;
import ru.alexander.cbr.repository.RegRepository;
import ru.alexander.cbr.repository.TnpRepository;
import ru.alexander.cbr.repository.UERRepository;

@Slf4j
@Scope(value = "session")
@Component(value = "bnkseekList")
@ELBeanName(value = "bnkseekList")
@Join(path = "/", to = "/bnkseek-list.jsf")
public class BNKSEEKListController {

    @Autowired
    private BNKSEEKRepository bNKSEEKRepository;

    @Autowired
    private UERRepository uERRepository;
    
    @Autowired
    private PznRepository pznRepository;
    
    @Autowired
    private RegRepository regRepository;
    
    @Autowired
    private TnpRepository tnpRepository;

    @Getter
    @Setter
    private List<BNKSEEK> bnkseekList;

    @Getter
    @Setter
    private List<UER> uerList;
    
    @Getter
    @Setter
    private List<Pzn> pznList;
    
    @Getter
    @Setter
    private List<Reg> regList;
    
    @Getter
    @Setter
    private List<Tnp> tnpList;
    
    @Getter
    @Setter
    private BnkseekFilter filter = new BnkseekFilter();

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        this.filter = new BnkseekFilter();
        this.bnkseekList = this.bNKSEEKRepository.findAll();
        this.uerList = this.uERRepository.findAll();
        this.pznList = this.pznRepository.findAll();
        this.regList = this.regRepository.findAll();
        this.tnpList = this.tnpRepository.findAll();
    }

    public void onRowEdit(RowEditEvent event) {
        BNKSEEK bnkseek = (BNKSEEK) event.getObject();
        bnkseek.setUER(this.uERRepository.findByUERNAME(bnkseek.getUERNAME()).getUER());
        bnkseek.setPZN(this.pznRepository.findByName(bnkseek.getPZNNAME()).getPzn());
        bnkseek.setRGN(this.regRepository.findByName(bnkseek.getREGNAME()).getRgn());
        bnkseek.setTNP(this.tnpRepository.findByFullname(bnkseek.getTNPNAME()).getTnp());
        this.bNKSEEKRepository.update(bnkseek);
        FacesMessage msg = new FacesMessage("Обновлено", (bnkseek.getVKEY()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Обновление отменено", ((BNKSEEK) event.getObject()).getVKEY());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void delete(BNKSEEK bnkseek) {
        this.bNKSEEKRepository.delete(bnkseek.getVKEY());
        this.bnkseekList.remove(bnkseek);
        FacesMessage msg = new FacesMessage("Удалено", bnkseek.getVKEY());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void search() {        
        this.bnkseekList = this.bNKSEEKRepository.findByFilter(this.filter);
    }

}
