package org.sarba.mybatis.datasource;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

public class DataSourceXmlTest {

    @Test
    public void testGetSqlSession() throws Exception {

        SqlSession sqlSession = DataSourceXml.INSTANCE.getSqlSession();
        System.out.println(sqlSession.getConfiguration().getEnvironment().getId());

    }

}