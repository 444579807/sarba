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
}
