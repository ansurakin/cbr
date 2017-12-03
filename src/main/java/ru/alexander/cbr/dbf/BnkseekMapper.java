/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexander.cbr.dbf;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.jamel.dbf.processor.DbfRowMapper;
import org.jamel.dbf.utils.DbfUtils;
import ru.alexander.cbr.model.BNKSEEK;

/**
 *
 * @author Alex
 */
@Slf4j
public class BnkseekMapper implements DbfRowMapper {

    private final String CHARSET = "CP866";

    @Override
    public BNKSEEK mapRow(Object[] row) {
        BNKSEEK bnkseek = new BNKSEEK();        
        try {
            bnkseek.setVKEY(new String(DbfUtils.trimLeftSpaces((byte[]) row[0]), this.CHARSET));
            bnkseek.setREAL(new String(DbfUtils.trimLeftSpaces((byte[]) row[1]), this.CHARSET));
            bnkseek.setPZN(new String(DbfUtils.trimLeftSpaces((byte[]) row[2]), this.CHARSET));
            bnkseek.setUER(new String(DbfUtils.trimLeftSpaces((byte[]) row[3]), this.CHARSET));
            bnkseek.setRGN(new String(DbfUtils.trimLeftSpaces((byte[]) row[4]), this.CHARSET));
            bnkseek.setIND(new String(DbfUtils.trimLeftSpaces((byte[]) row[5]), this.CHARSET));
            bnkseek.setTNP(new String(DbfUtils.trimLeftSpaces((byte[]) row[6]), this.CHARSET));
            bnkseek.setNNP(new String(DbfUtils.trimLeftSpaces((byte[]) row[7]), this.CHARSET));
            bnkseek.setADR(new String(DbfUtils.trimLeftSpaces((byte[]) row[8]), this.CHARSET));
            bnkseek.setRKC(new String(DbfUtils.trimLeftSpaces((byte[]) row[9]), this.CHARSET));
            bnkseek.setNAMEP(new String(DbfUtils.trimLeftSpaces((byte[]) row[10]), this.CHARSET));
            bnkseek.setNEWNUM(new String(DbfUtils.trimLeftSpaces((byte[]) row[12]), this.CHARSET));
            bnkseek.setTELEF(new String(DbfUtils.trimLeftSpaces((byte[]) row[18]), this.CHARSET));
            bnkseek.setREGN(new String(DbfUtils.trimLeftSpaces((byte[]) row[19]), this.CHARSET));
            bnkseek.setOKPO(new String(DbfUtils.trimLeftSpaces((byte[]) row[20]), this.CHARSET));
            bnkseek.setDT_IZM(getDate(row[21]));
            bnkseek.setKSNP(new String(DbfUtils.trimLeftSpaces((byte[]) row[23]), this.CHARSET));
            bnkseek.setDATE_IN(getDate(row[24]));
            bnkseek.setDATE_CH(getDate(row[25]));
        } catch (UnsupportedEncodingException ex) {
            log.error("Неверная кодировка " + ex.getMessage());
        }
        return bnkseek;
    }

    private Date getDate(Object str) {        
        Date result = (Date) str;
        if (result.toString().equals("Tue Oct 06 00:00:00 MSK 17793")) {//соответствует null
            result = null;
        }
        return result;                
    }

}
