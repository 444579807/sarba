package org.sarba.mybatis.datasource;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.sql.Connection;

import static org.testng.Assert.*;

public class MybatiesDataSourceTest {
    @Test
    public void testGetDruidSqlSession() throws Exception {
        SqlSession sqlSession = MybatiesDataSource.INSTANCE.getDruidSqlSession();
        System.out.println(sqlSession.getConnection().getMetaData().getUserName());
    }

    @Test
    public void testGetHikariSqlSession() throws Exception {
        SqlSession sqlSession = MybatiesDataSource.INSTANCE.getHikariSqlSession();
        System.out.println(sqlSession.getConnection().getMetaData().getUserName());
    }

    @Test
    public void testGetPooledSqlSession() throws Exception {
        SqlSession sqlSession = MybatiesDataSource.INSTANCE.getPooledSqlSession();
        System.out.println(sqlSession.getConnection().getMetaData().getUserName());
    }

}