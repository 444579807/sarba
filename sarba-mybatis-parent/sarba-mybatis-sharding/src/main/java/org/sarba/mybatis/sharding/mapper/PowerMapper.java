package org.sarba.mybatis.sharding.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sarba.mybatis.entity.Power;

import java.util.List;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-08-14 16:14
 * @description:
 **/
@Mapper
public interface PowerMapper {

    @Select("select * from power order by id asc limit 0,10")
    public List<Power> queryPowers();

    @Select("select * from power where power_name like #{powerName} order by id asc limit 1000000,10")
    public List<Power> queryPowersLikePowerName(String powerName);

    @Select("select * from power where id = #{id}")
    public Power queryPowerById(Integer id);

    @Select("select count(*) from power")
    public Long count();

    @Insert("insert into power(power_name)values(#{powerName})")
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
}
