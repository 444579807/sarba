package org.sarba.mybatis.datasource.strategy;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.sarba.mybatis.datasource.properties.DataBases;

import javax.sql.DataSource;

public class PooledStrategy implements DataSourceStrategy {
    @Override
    public DataSource getDataSource(DataBases dataBases) {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(dataBases.getDriverClassName());
        dataSource.setUrl(dataBases.getUrl());
        dataSource.setUsername(dataBases.getUserName());
        dataSource.setPassword(dataBases.getPassWord());
        return dataSource;
    }
}
