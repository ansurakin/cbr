package ru.alexander.cbr.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Alex
 */
@Data
public class Reg {
    
    @Length(max = 2, message = "The field must be less than {max} characters")
    private String vkey;
    
    @Length(max = 2, message = "The field must be less than {max} characters")
    private String rgn;
        
    @Length(max = 40, message = "The field must be less than {max} characters")
    private String name;
    
    @Length(max = 30, message = "The field must be less than {max} characters")
    private String center;
    
    @Length(max = 40, message = "The field must be less than {max} characters")
    private String namet;
    
}
