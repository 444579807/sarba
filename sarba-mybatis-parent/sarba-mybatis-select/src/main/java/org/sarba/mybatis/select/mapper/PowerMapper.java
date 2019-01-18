package org.sarba.mybatis.select.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.sarba.mybatis.entity.Power;

import java.util.List;

@Mapper
public interface PowerMapper {

    @Select("select * from power")
    public List<Power> queryPowers();

    @Select("select * from power where id = #{id}")
    public Power queryPowerById(Integer id);

}
