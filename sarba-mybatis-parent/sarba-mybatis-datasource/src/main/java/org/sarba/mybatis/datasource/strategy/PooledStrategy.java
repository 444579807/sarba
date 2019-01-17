package org.sarba.mybatis.datasource.strategy;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.sarba.mybatis.datasource.properties.DBProperties;
import org.sarba.mybatis.datasource.properties.DataBases;

import javax.sql.DataSource;

public class PooledStrategy implements DataSourceStrategy {
    @Override
    public DataSource getDataSource(DataBases dataBases) {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(DBProperties.getDataBases().getDriverClassName());
        dataSource.setUrl(DBProperties.getDataBases().getUrl());
        dataSource.setUsername(DBProperties.getDataBases().getUserName());
        dataSource.setPassword(DBProperties.getDataBases().getPassWord());
        return dataSource;
    }
}
