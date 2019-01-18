package org.sarba.mybatis.xmlmapper.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sarba.mybatis.entity.Power;

import java.util.List;

@Mapper
public interface PowerMapper {

    public List<Power> queryPowers();

    public void batchSave(List<Power> powers);

}
