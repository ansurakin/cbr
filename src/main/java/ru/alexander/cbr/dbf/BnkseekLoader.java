package ru.alexander.cbr.dbf;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.jamel.dbf.processor.DbfProcessor;
import org.jamel.dbf.processor.DbfRowMapper;
import org.jamel.dbf.utils.DbfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alexander.cbr.model.BNKSEEK;
import ru.alexander.cbr.repository.BNKSEEKRepository;

/**
 *
 * @author Alex
 */
@Slf4j
@Component
public class BnkseekLoader {
    
    
    @Autowired
    private BNKSEEKRepository bNKSEEKRepository;
    
    public void load(InputStream dbf){
//        this.bNKSEEKRepository.insert(new BNKSEEK());
        log.debug("Получена команда на загрузку");
        log.debug("Очистка таблицы");
        this.bNKSEEKRepository.truncate();        
        List<BNKSEEK> bnkseeks = getObjectList(dbf);
        log.debug("Вставка записей " + bnkseeks.size());        
        for (BNKSEEK bnkseek : bnkseeks) {
            log.debug(bnkseek.toString());
           this.bNKSEEKRepository.insert(bnkseek);
        }
    }
    
    public List<BNKSEEK> getObjectList(InputStream dbf){
        log.debug("Получение списка обектов");
        return DbfProcessor.loadData(dbf, new BnkseekMapper());
    }
    
}
