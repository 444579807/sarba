package org.sarba.mybatis.select.mapper;

import org.apache.ibatis.annotations.*;
import org.sarba.mybatis.entity.Power;

import java.util.List;

@Mapper
public interface PowerMapper {

    @Select("select * from power")
    public List<Power> queryPowers();

    @Select("select * from power where id = #{id}")
    public Power queryPowerById(Integer id);

    @Insert("insert into power(power_name)values(#{powerName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insert(Power power);

    @Insert({
            "<script>",
            "insert into power(power_name) values ",
            "<foreach collection='powers' item='item' index='index' separator=','>",
            "(#{item.powerName})",
            "</foreach>",
            "</script>"
    })
    public int inserBatch(@Param("powers") List<Power> powers);

    @Select("select count(*) from power")
    public Long count();

}
