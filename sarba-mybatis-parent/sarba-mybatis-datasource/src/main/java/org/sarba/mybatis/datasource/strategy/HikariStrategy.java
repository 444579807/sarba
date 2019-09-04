package org.sarba.mybatis.datasource.strategy;

import com.zaxxer.hikari.HikariDataSource;
import org.sarba.mybatis.datasource.properties.DBProperties;
import org.sarba.mybatis.datasource.properties.DataBases;

import javax.sql.DataSource;

public class HikariStrategy implements DataSourceStrategy {
    @Override
    public DataSource getDataSource(DataBases dataBases) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(dataBases.getDriverClassName());
        dataSource.setJdbcUrl(dataBases.getUrl());
        dataSource.setUsername(dataBases.getUserName());
        dataSource.setPassword(dataBases.getPassWord());
        return dataSource;
    }
}
