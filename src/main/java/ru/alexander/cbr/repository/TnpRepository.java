package ru.alexander.cbr.repository;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import ru.alexander.cbr.model.Tnp;

/**
 *
 * @author Alex
 */
public interface TnpRepository {
    
    @Select("SELECT * FROM tnp")
    public List<Tnp> findAll();

    @Select("SELECT * FROM tnp WHERE fullname = #{fullname}")
    public Tnp findByFullname(String fullname);
    
}
