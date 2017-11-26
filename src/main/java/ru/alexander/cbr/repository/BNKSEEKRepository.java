package ru.alexander.cbr.repository;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import ru.alexander.cbr.model.BNKSEEK;

/**
 *
 * @author Alex
 */
public interface BNKSEEKRepository {

    @Select("SELECT\n"
            + "	b.*, u.UERNAME\n"
            + "FROM\n"
            + "	BNKSEEK b\n"
            + "LEFT JOIN UER u ON b.UER = u.UER")
    List<BNKSEEK> findAll();
}
