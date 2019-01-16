package org.sarba.mybatis.hello.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public enum  DBUtil {

    INSTANCE;

    public SqlSessionFactory  getSessionFactory(){
        SqlSessionFactory sqlSessionFactory = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

}
