package org.sarba.mybatis.datasource.strategy;

import com.zaxxer.hikari.HikariDataSource;
import org.sarba.mybatis.datasource.properties.DBProperties;
import org.sarba.mybatis.datasource.properties.DataBases;

import javax.sql.DataSource;

public class HikariStrategy implements DataSourceStrategy {
    @Override
    public DataSource getDataSource(DataBases dataBases) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(DBProperties.getDataBases().getDriverClassName());
        dataSource.setJdbcUrl(DBProperties.getDataBases().getUrl());
        dataSource.setUsername(DBProperties.getDataBases().getUserName());
        dataSource.setPassword(DBProperties.getDataBases().getPassWord());
        return dataSource;
    }
}
