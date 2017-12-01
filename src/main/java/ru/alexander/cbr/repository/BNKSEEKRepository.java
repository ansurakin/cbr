package ru.alexander.cbr.repository;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.alexander.cbr.model.BNKSEEK;
import ru.alexander.cbr.model.BnkseekFilter;

/**
 *
 * @author Alex
 */
public interface BNKSEEKRepository {

    @Select("SELECT\n"
            + "	b.*, \n"
            + "  p.name PZNNAME,\n"
            + "	t.fullname TNPNAME,\n"
            + "	u.UERNAME,\n"
            + "	r.name REGNAME\n"
            + "FROM\n"
            + "	BNKSEEK b\n"
            + "LEFT JOIN pzn p ON b.pzn = p.pzn\n"
            + "LEFT JOIN tnp t ON b.tnp = t.tnp\n"
            + "LEFT JOIN UER u ON b.UER = u.UER\n"
            + "LEFT JOIN reg r ON b.rgn = r.rgn\n"
            + "ORDER BY b.VKEY")
    public List<BNKSEEK> findAll();

    @Insert("INSERT INTO BNKSEEK \n"
            + "(VKEY,REAL,PZN,UER,RGN,IND,TNP,NNP,ADR,RKC,NAMEP,NEWNUM,TELEF,REGN,OKPO,DT_IZM,KSNP,DATE_IN,DATE_CH) \n"
            + "VALUES\n"
            + "(#{VKEY},#{REAL},#{PZN},#{UER},#{RGN},#{IND},#{TNP},#{NNP},#{ADR},#{RKC},#{NAMEP},#{NEWNUM},#{TELEF},#{REGN},#{OKPO},#{DT_IZM},#{KSNP},#{DATE_IN},#{DATE_CH})"
    )
    public void insert(BNKSEEK bnkseek);

    @Update("UPDATE BNKSEEK\n"
            + "SET \n"
            + " REAL = #{REAL},\n"
            + " PZN = #{PZN},\n"
            + " UER = #{UER},\n"
            + " RGN = #{RGN},\n"
            + " IND = #{IND},\n"
            + " TNP = #{TNP},\n"
            + " NNP = #{NNP},\n"
            + " ADR = #{ADR},\n"
            + " RKC = #{RKC},\n"
            + " NAMEP = #{NAMEP},\n"
            + " NEWNUM = #{NEWNUM},\n"
            + " TELEF = #{TELEF},\n"
            + " REGN = #{REGN},\n"
            + " OKPO = #{OKPO},\n"
            + " DT_IZM = #{DT_IZM},\n"
            + " KSNP = #{KSNP},\n"
            + " DATE_IN = #{DATE_IN},\n"
            + " DATE_CH = #{DATE_CH}\n"
            + "WHERE\n"
            + "	VKEY = #{VKEY}")
    public void update(BNKSEEK bnkseek);

    @Delete("DELETE FROM BNKSEEK WHERE VKEY = #{vkey}")
    public void delete(String vkey);

    @Select("SELECT\n"
            + "	b.*, \n"
            + "  p.name PZNNAME,\n"
            + "	t.fullname TNPNAME,\n"
            + "	u.UERNAME,\n"
            + "	r.name REGNAME\n"
            + "FROM\n"
            + "	BNKSEEK b\n"
            + "LEFT JOIN pzn p ON b.pzn = p.pzn\n"
            + "LEFT JOIN tnp t ON b.tnp = t.tnp\n"
            + "LEFT JOIN UER u ON b.UER = u.UER\n"
            + "LEFT JOIN reg r ON b.rgn = r.rgn\n"
            + "WHERE\n"
            + "	(CASE WHEN #{bik} IS NULL OR LENGTH(#{bik}) = 0 THEN TRUE ELSE b.newnum = #{bik} END)\n"
            + "AND (CASE WHEN #{region} IS NULL OR LENGTH(#{region}) = 0 THEN TRUE ELSE b.rgn = #{region} END)\n"
            + "AND (CASE WHEN #{typePzn} IS NULL OR LENGTH(#{typePzn}) = 0 THEN TRUE ELSE p.name = #{typePzn} END)\n"
            + "ORDER BY b.VKEY")
    public List<BNKSEEK> findByFilter(BnkseekFilter filter);

}
