package ru.alexander.cbr.model;

import lombok.Data;

/**
 *
 * @author Alex
 */
@Data
public class BnkseekFilter {
    
    private String bik;
    
    private String region;
    
    private String typePzn;
    
}
