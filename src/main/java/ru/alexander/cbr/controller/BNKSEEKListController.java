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
import javafx.scene.control.TableColumn.CellEditEvent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import ru.alexander.cbr.model.BNKSEEK;
import ru.alexander.cbr.model.UER;
import ru.alexander.cbr.repository.BNKSEEKRepository;
import ru.alexander.cbr.repository.UERRepository;

@Scope(value = "session")
@Component(value = "bnkseekList")
@ELBeanName(value = "bnkseekList")
@Join(path = "/", to = "/bnkseek-list.jsf")
public class BNKSEEKListController {

    @Autowired
    private BNKSEEKRepository bNKSEEKRepository;    
    
    @Autowired
    private UERRepository uERRepository;

    @Getter
    @Setter
    private List<BNKSEEK> bnkseekList;
    
    @Getter
    @Setter
    private List<UER> uerList;

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        this.bnkseekList = this.bNKSEEKRepository.findAll();
        this.uerList = this.uERRepository.findAll();
    }
     
    public void onCellEdit(CellEditEvent event) {
        System.out.println("11111111111111");
        
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        
        
        
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
