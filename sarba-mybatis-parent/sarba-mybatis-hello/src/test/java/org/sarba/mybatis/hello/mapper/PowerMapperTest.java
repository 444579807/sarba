package org.sarba.mybatis.hello.mapper;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.sarba.mybatis.entity.Power;
import org.sarba.mybatis.hello.db.DBUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class PowerMapperTest {

    private Log log = LogFactory.getLog(PowerMapperTest.class);

    SqlSessionFactory sqlSessionFactory ;

    @BeforeMethod
    public void setUp() throws Exception {
        sqlSessionFactory = DBUtil.INSTANCE.getSessionFactory();
    }
    @Test
    public void testSelectPowers() throws Exception {
        log.error("ssssssssssssss");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PowerMapper powerMapper = sqlSession.getMapper(PowerMapper.class);
        try {
            powerMapper.selectPowers().forEach(power -> System.out.println(power.getPowerName()));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectPowers2() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PowerMapper powerMapper = sqlSession.getMapper(PowerMapper.class);
        try {
            powerMapper.selectPowers2().forEach(power -> System.out.println(power.getPowerName()));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSave() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        PowerMapper powerMapper = sqlSession.getMapper(PowerMapper.class);
        sqlSession.commit(false);
        try {
            for (int i = 0; i <10000 ; i++) {
                Power power = new Power("测试" + i);
                powerMapper.save(power);
            }
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }

    @Test
    public void testBatchSave() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE);
        PowerMapper powerMapper = sqlSession.getMapper(PowerMapper.class);
        sqlSession.commit(false);
        try {
            List<Power> powers = new ArrayList<Power>();
            for (int i = 0; i <10000 ; i++) {
                Power power = new Power("测试" + i);
                powers.add(power);
            }
            powerMapper.batchSave(powers);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}