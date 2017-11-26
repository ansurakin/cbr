package ru.alexander.cbr.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Alex
 */
@Data
public class BNKSEEK {
    
    @Length(max = 8, message = "The field must be less than {max} characters")
    private String VKEY;

    @Length(max = 4, message = "The field must be less than {max} characters")
    private String REAL;

    @Length(max = 2, message = "The field must be less than {max} characters")
    private String PZN;

    @Length(max = 1, message = "The field must be less than {max} characters")
    private String UER;

    @Length(max = 2, message = "The field must be less than {max} characters")
    private String RGN;

    @Length(max = 6, message = "The field must be less than {max} characters")
    private String IND;

    @Length(max = 1, message = "The field must be less than {max} characters")
    private String TNP;

    @Length(max = 25, message = "The field must be less than {max} characters")
    private String NNP;

    @Length(max = 30, message = "The field must be less than {max} characters")
    private String ADR;

    @Length(max = 9, message = "The field must be less than {max} characters")
    private String RKC;

    @Length(max = 45, message = "The field must be less than {max} characters")
    private String NAMEP;

    @Length(max = 9, message = "The field must be less than {max} characters")
    private String NEWNUM;

    @Length(max = 25, message = "The field must be less than {max} characters")
    private String TELEF;

    @Length(max = 9, message = "The field must be less than {max} characters")
    private String REGN;

    @Length(max = 8, message = "The field must be less than {max} characters")
    private String OKPO;

    private String DT_IZM;

    @Length(max = 20, message = "The field must be less than {max} characters")
    private String KSNP;

    private String DATE_IN;

    private String DATE_CH;
    
    
    private String UERNAME;

}
