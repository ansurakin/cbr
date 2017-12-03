package ru.alexander.cbr.controller;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
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

/**
 *
 * @author Alex
 */
@Slf4j
@Scope(value = "session")
@Component(value = "bnkseekController")
@ELBeanName(value = "bnkseekController")
@Join(path = "/bnkseek", to = "/bnkseek-form.jsf")
public class BNKSEEKController {

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
    private BNKSEEK bnkseek = new BNKSEEK();

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        this.bnkseek = new BNKSEEK();
        this.uerList = this.uERRepository.findAll();
        this.pznList = this.pznRepository.findAll();
        this.regList = this.regRepository.findAll();
        this.tnpList = this.tnpRepository.findAll();
    }

    public String save() {
        log.debug(this.bnkseek.toString());
        this.bnkseek.setVKEY(java.util.UUID.randomUUID().toString());
        UER findedUer = this.uERRepository.findByUERNAME(this.bnkseek.getUERNAME());
        if (findedUer != null) {
            this.bnkseek.setUER(findedUer.getUER());
        }
        Pzn findedPzn = this.pznRepository.findByName(this.bnkseek.getPZNNAME());
        if (findedPzn != null) {
            this.bnkseek.setPZN(findedPzn.getPzn());
        }
        Reg findedReg = this.regRepository.findByName(this.bnkseek.getREGNAME());
        if (findedReg != null) {
            this.bnkseek.setRGN(findedReg.getRgn());
        }
        Tnp findedTnp = this.tnpRepository.findByFullname(this.bnkseek.getTNPNAME());
        if (findedTnp != null) {
            this.bnkseek.setTNP(findedTnp.getTnp());
        }        
        this.bNKSEEKRepository.insert(bnkseek);
        return "/bnkseek-list.xhtml?faces-redirect=true";
    }

}
