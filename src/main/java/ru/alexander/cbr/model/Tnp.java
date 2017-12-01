package ru.alexander.cbr.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Alex
 */
@Data
public class Tnp {
    
    @Length(max = 2, message = "The field must be less than {max} characters")
    private String vkey;
    
    @Length(max = 2, message = "The field must be less than {max} characters")
    private String tnp;
        
    @Length(max = 25, message = "The field must be less than {max} characters")
    private String fullname;
    
    @Length(max = 5, message = "The field must be less than {max} characters")
    private String shortname;
        
}
