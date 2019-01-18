package org.sarba.mybatis.datasource.strategy;

import com.alibaba.druid.pool.DruidDataSource;
import org.sarba.mybatis.datasource.properties.DBProperties;
import org.sarba.mybatis.datasource.properties.DataBases;

import javax.sql.DataSource;

public class DruidStrategy implements DataSourceStrategy {
    @Override
    public DataSource getDataSource(DataBases dataBases) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(DBProperties.INSTANCE.getDataBases().getDriverClassName());
        dataSource.setUrl(DBProperties.INSTANCE.getDataBases().getUrl());
        dataSource.setUsername(DBProperties.INSTANCE.getDataBases().getUserName());
        dataSource.setPassword(DBProperties.INSTANCE.getDataBases().getPassWord());
        return dataSource;
    }
}
