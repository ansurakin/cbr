package ru.alexander.cbr.controller;

import lombok.Getter;
import lombok.Setter;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.alexander.cbr.model.BNKSEEK;
import ru.alexander.cbr.repository.BNKSEEKRepository;
import ru.alexander.cbr.repository.UERRepository;

/**
 *
 * @author Alex
 */
@Scope(value = "request")
@Component(value = "bnkseekController")
@ELBeanName(value = "bnkseekController")
@Join(path = "/bnkseek", to = "/bnkseek-form.jsf")
public class BNKSEEKController {    
    
    @Autowired
    private BNKSEEKRepository bNKSEEKRepository;

    @Autowired
    private UERRepository uERRepository;
    
    @Getter @Setter
    private BNKSEEK bnkseek = new BNKSEEK();

    public String save() {
        this.bnkseek.setVKEY(java.util.UUID.randomUUID().toString());
        this.bNKSEEKRepository.insert(bnkseek);        
        return "/bnkseek-list.xhtml?faces-redirect=true";
    }
    
}
