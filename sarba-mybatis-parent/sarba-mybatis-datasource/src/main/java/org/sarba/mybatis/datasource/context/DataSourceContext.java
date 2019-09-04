package org.sarba.mybatis.datasource.context;

import org.sarba.mybatis.datasource.properties.DBProperties;
import org.sarba.mybatis.datasource.strategy.DataSourceStrategy;

import javax.sql.DataSource;

public class DataSourceContext {

    private DataSourceStrategy dataSourceStrategy;

    public DataSourceContext(DataSourceStrategy dataSourceStrategy) {
        this.dataSourceStrategy = dataSourceStrategy;
    }

    public DataSource  getDataSource(){
        return dataSourceStrategy.getDataSource(DBProperties.INSTANCE.getDataBases());
    }

    public DataSource getDataSource(String databases){
        return dataSourceStrategy.getDataSource(DBProperties.INSTANCE.getDataBases(databases));
    }

    public DataSource getDataSource(String host,String database){
        return dataSourceStrategy.getDataSource(DBProperties.INSTANCE.getDataBases(host,database));
    }
    public DataSource getDataSource(String host,String database,String password){
        return dataSourceStrategy.getDataSource(DBProperties.INSTANCE.getDataBases(host,database,password));
    }

    public DataSource getDataSource(String host,String port,String database,String password){
        return dataSourceStrategy.getDataSource(DBProperties.INSTANCE.getDataBases(host,port,database,password));
    }

}
