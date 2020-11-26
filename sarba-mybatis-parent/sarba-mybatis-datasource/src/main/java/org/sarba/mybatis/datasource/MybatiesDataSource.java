package org.sarba.mybatis.datasource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.sarba.mybatis.datasource.context.DataSourceContext;
import org.sarba.mybatis.datasource.strategy.DruidStrategy;
import org.sarba.mybatis.datasource.strategy.HikariStrategy;
import org.sarba.mybatis.datasource.strategy.PooledStrategy;

import javax.sql.DataSource;
import java.util.HashMap;

public enum  MybatiesDataSource {

    INSTANCE;

    private static final HashMap<String, SqlSessionFactory> dataSourceMap = new HashMap<String, SqlSessionFactory>();

    static {
        dataSourceMap.put("druid",getDruidSqlSessionFactory());
        dataSourceMap.put("hikari",getHikariSqlSessionFactory());
        dataSourceMap.put("pooled",getPooledSqlSessionFactory());
    }

    private static SqlSessionFactory getDruidSqlSessionFactory(){
        return  getSqlSessionFactory(new DataSourceContext(new DruidStrategy()).getDataSource());
    }

    private static SqlSessionFactory getHikariSqlSessionFactory(){
        return  getSqlSessionFactory(new DataSourceContext(new HikariStrategy()).getDataSource());
    }

    private static SqlSessionFactory getPooledSqlSessionFactory(){
        return  getSqlSessionFactory(new DataSourceContext(new PooledStrategy()).getDataSource());
    }

    private static SqlSessionFactory getSqlSessionFactory(DataSource dataSource){
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        return new SqlSessionFactoryBuilder().build(configuration);
    }


    public SqlSession getDruidSqlSession(){
        return dataSourceMap.get("druid").openSession();
    }

    public SqlSession getHikariSqlSession(){
        return dataSourceMap.get("hikari").openSession();
    }

    public SqlSession getHikariSqlSession(ExecutorType executorType){
        return dataSourceMap.get("hikari").openSession(executorType);
    }

    public SqlSession getPooledSqlSession(){
        return dataSourceMap.get("pooled").openSession();
    }

}
