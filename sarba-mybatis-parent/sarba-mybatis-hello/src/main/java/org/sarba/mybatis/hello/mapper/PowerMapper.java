package org.sarba.mybatis.hello.mapper;

import org.apache.ibatis.annotations.Select;
import org.sarba.mybatis.hello.entity.Power;

import java.util.List;

public interface PowerMapper {

    public List<Power> selectPowers();

    @Select("select * from power")
    public List<Power> selectPowers2();

    public void save(Power power);

    public void batchSave(List<Power> powers);



}
