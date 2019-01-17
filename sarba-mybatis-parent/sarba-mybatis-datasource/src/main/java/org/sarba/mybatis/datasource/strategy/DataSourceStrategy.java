package org.sarba.mybatis.datasource.strategy;

import org.sarba.mybatis.datasource.properties.DataBases;

import javax.sql.DataSource;

public interface DataSourceStrategy {

    public DataSource  getDataSource(DataBases dataBases);

}
