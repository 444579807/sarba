package org.sarba.mybatis.sharding.config;

import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.sarba.mybatis.datasource.context.DataSourceContext;
import org.sarba.mybatis.datasource.strategy.HikariStrategy;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-08-16 10:09
 * @description:
 **/
public class MyShardingDateSource {


    public DataSource getDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getPowerTableRuleConfiguration());
        shardingRuleConfig.getBindingTableGroups().add("power");
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("id",new PowerDatabasePreciseShardingAlgorithm()));
        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("id",new PowerPreciseShardingAlgorithm()));
        return ShardingDataSourceFactory.createDataSource(createDateSourceMap(),shardingRuleConfig,getProperties());
    }

    private Map<String,DataSource> createDateSourceMap(){
        Map<String,DataSource> dataSourceMap =  new HashMap<String, DataSource>();
        dataSourceMap.put("mybatis_0",new DataSourceContext(new HikariStrategy()).getDataSource("192.168.3.108","3306","mybatis_0","1qazxsw2"));
        dataSourceMap.put("mybatis_1",new DataSourceContext(new HikariStrategy()).getDataSource("192.168.3.108","3307","mybatis_1","1qazxsw2"));
        dataSourceMap.put("mybatis_2",new DataSourceContext(new HikariStrategy()).getDataSource("192.168.3.108","3308","mybatis_2","1qazxsw2"));
        dataSourceMap.put("mybatis_3",new DataSourceContext(new HikariStrategy()).getDataSource("192.168.3.235","mybatis_3"));
        dataSourceMap.put("mybatis_4",new DataSourceContext(new HikariStrategy()).getDataSource("192.168.3.235","mybatis_4"));
        dataSourceMap.put("mybatis_5",new DataSourceContext(new HikariStrategy()).getDataSource("192.168.3.235","mybatis_5"));
        dataSourceMap.put("mybatis_6",new DataSourceContext(new HikariStrategy()).getDataSource("192.168.3.101","mybatis_6","1qazxsw2"));
        dataSourceMap.put("mybatis_7",new DataSourceContext(new HikariStrategy()).getDataSource("192.168.3.101","mybatis_7","1qazxsw2"));
        dataSourceMap.put("mybatis_8",new DataSourceContext(new HikariStrategy()).getDataSource("192.168.3.101","mybatis_8","1qazxsw2"));
        dataSourceMap.put("mybatis_9",new DataSourceContext(new HikariStrategy()).getDataSource("192.168.3.101","mybatis_9","1qazxsw2"));
        return dataSourceMap;
    }
    private static KeyGeneratorConfiguration getKeyGeneratorConfiguration() {
        return new KeyGeneratorConfiguration("SNOWFLAKE","id",getProperties());
    }

    public TableRuleConfiguration getPowerTableRuleConfiguration() {
        TableRuleConfiguration powerTableRuleConfiguration = new TableRuleConfiguration("power","mybatis_${0..9}.power${0..9}");
        powerTableRuleConfiguration.setKeyGeneratorConfig(getKeyGeneratorConfiguration());
        return powerTableRuleConfiguration;
    }

    private static Properties getProperties(){
        Properties props=new Properties();
        props.setProperty("sql.show", "true");
        return props;
    }
}
