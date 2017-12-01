package ru.alexander.cbr.repository;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import ru.alexander.cbr.model.Reg;

/**
 *
 * @author Alex
 */
public interface RegRepository {
    
    @Select("SELECT * FROM reg")
    public List<Reg> findAll();

    @Select("SELECT * FROM reg WHERE name = #{name}")
    public Reg findByName(String name);
    
}
