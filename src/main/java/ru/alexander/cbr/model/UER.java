/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexander.cbr.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Alex
 */
@Data
public class UER {
    
    @Length(max = 2, message = "The field must be less than {max} characters")
    private String VKEY;
    
    @Length(max = 1, message = "The field must be less than {max} characters")
    private String UER;
    
    @Length(max = 70, message = "The field must be less than {max} characters")
    private String UERNAME;
    
}
