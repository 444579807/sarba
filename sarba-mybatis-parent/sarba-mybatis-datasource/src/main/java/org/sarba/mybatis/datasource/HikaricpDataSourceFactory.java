package org.sarba.mybatis.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class HikaricpDataSourceFactory extends UnpooledDataSourceFactory {

    public HikaricpDataSourceFactory() {
        this.dataSource = new HikariDataSource();
    }
}
