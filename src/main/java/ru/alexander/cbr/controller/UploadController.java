package ru.alexander.cbr.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.alexander.cbr.dbf.BnkseekLoader;
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
@Component(value = "uploadController")
@ELBeanName(value = "uploadController")
@Join(path = "/upload", to = "/upload-form.jsf")
public class UploadController {

    @Getter
    @Setter
    private UploadedFile file;

    @Getter
    @Setter
    private String fileContent;

    @Getter
    @Setter
    private String fileName;
    
    @Autowired
    BnkseekLoader loader;

    public void handleUpload(FileUploadEvent event) {
        log.debug("Загрузка началась");
        UploadedFile file = event.getFile();
        byte[] contents = file.getContents();
        InputStream inputStream = new ByteArrayInputStream(contents);
        loader.load(inputStream);
        this.fileName = file.getFileName();
        log.debug("Загрузка файла завершена");
    }

}
