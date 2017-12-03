package ru.alexander.cbr.model;

import java.util.Date;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Alex
 */
@Data
public class Pzn {
    
    @Length(max = 2, message = "The field must be less than {max} characters")
    private String vkey;
    
    @Length(max = 2, message = "The field must be less than {max} characters")
    private String pzn;
    
    @Length(max = 4, message = "The field must be less than {max} characters")
    private String imy;
    
    @Length(max = 40, message = "The field must be less than {max} characters")
    private String name;
    
    private Date cb_date;
    
    private Date ce_date;
    
}
