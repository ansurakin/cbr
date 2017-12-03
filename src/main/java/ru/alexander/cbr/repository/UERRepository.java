/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexander.cbr.repository;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import ru.alexander.cbr.model.UER;

/**
 *
 * @author Alex
 */
public interface UERRepository {
    
    @Select("SELECT * FROM UER")
    public List<UER> findAll();

    @Select("SELECT * FROM UER WHERE UERNAME = #{uername}")
    public UER findByUERNAME(String uername);
    
}
