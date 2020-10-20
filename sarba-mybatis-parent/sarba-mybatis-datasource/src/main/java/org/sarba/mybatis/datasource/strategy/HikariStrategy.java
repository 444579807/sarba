package org.sarba.mybatis.datasource.strategy;

import com.zaxxer.hikari.HikariDataSource;
import org.sarba.mybatis.datasource.properties.DBProperties;
import org.sarba.mybatis.datasource.properties.DataBases;

import javax.sql.DataSource;

public class HikariStrategy implements DataSourceStrategy {
    @Override
    public DataSource getDataSource(DataBases dataBases) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(DBProperties.INSTANCE.getDataBases().getDriverClassName());
        dataSource.setJdbcUrl(DBProperties.INSTANCE.getDataBases().getUrl());
        dataSource.setUsername(DBProperties.INSTANCE.getDataBases().getUserName());
        dataSource.setPassword(DBProperties.INSTANCE.getDataBases().getPassWord());
        return dataSource;
    }
}
