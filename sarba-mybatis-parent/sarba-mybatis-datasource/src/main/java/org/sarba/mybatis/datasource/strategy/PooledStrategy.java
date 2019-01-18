package org.sarba.mybatis.datasource.strategy;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.sarba.mybatis.datasource.properties.DBProperties;
import org.sarba.mybatis.datasource.properties.DataBases;

import javax.sql.DataSource;

public class PooledStrategy implements DataSourceStrategy {
    @Override
    public DataSource getDataSource(DataBases dataBases) {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(DBProperties.INSTANCE.getDataBases().getDriverClassName());
        dataSource.setUrl(DBProperties.INSTANCE.getDataBases().getUrl());
        dataSource.setUsername(DBProperties.INSTANCE.getDataBases().getUserName());
        dataSource.setPassword(DBProperties.INSTANCE.getDataBases().getPassWord());
        return dataSource;
    }
}
