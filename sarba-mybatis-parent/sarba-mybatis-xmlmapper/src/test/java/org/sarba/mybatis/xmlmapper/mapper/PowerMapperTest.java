package org.sarba.mybatis.xmlmapper.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.sarba.mybatis.entity.Power;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class PowerMapperTest {

    private PowerMapper powerMapper;
    private SqlSessionFactory sqlSessionFactory;
    @BeforeClass
    public void setUp() throws Exception {
       InputStream inputStream =  Resources.getResourceAsStream("mybatis-config.xml");
       sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testQueryPowers() throws Exception {
        //System.out.println(powerMapper.queryPowers().size());
    }

    @Test(threadPoolSize = 25,invocationCount = 1000)
    public void testBatchSave() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        for (int i = 0; i < 10 ; i++) {
            sqlSession.commit(false);
            powerMapper = sqlSession.getMapper(PowerMapper.class);
            List<Power> powers = new ArrayList<Power>();
            for (int j = 0; j <10000 ; j++) {
                powers.add(new Power("测试" + i));
            }
            powerMapper.batchSave(powers);
            sqlSession.commit();
        }
        sqlSession.close();
    }

    @AfterClass
    public void tearDown() throws Exception {
    }

}