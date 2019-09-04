package org.sarba.mybatis.sharding;

import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.sarba.mybatis.entity.Power;
import org.sarba.mybatis.sharding.config.MyShardingDateSource;
import org.sarba.mybatis.sharding.mapper.PowerMapper;
import org.testng.annotations.*;

import javax.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;

public class PowerMapperTest {
    private SqlSession sqlSession;
    private PowerMapper powerMapper;

    @BeforeClass
    public void setUp() throws Exception {
      /*获取Hikari连接池连接*/
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, new MyShardingDateSource().getDataSource());
        Configuration configuration = new Configuration(environment);
        //TransactionTypeHolder.set(TransactionType.XA);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        sqlSession = sqlSessionFactory.openSession();
        sqlSession.getConfiguration().setLogImpl(Log4j2Impl.class);
      /*添加mapper到session中*/
      /*直接添加包扫描*/
        //sqlSession.getConfiguration().addMappers("org.sarba.mybatis.select.mapper");
      /*添加单个实体*/
        sqlSession.getConfiguration().addMapper(PowerMapper.class);
        //获取mapper
        powerMapper = sqlSession.getMapper(PowerMapper.class);
    }

    @Test
    public void testQueryPowers() throws Exception {
        List<Power> powers = powerMapper.queryPowers();
        for (Power power : powers) {
            System.out.println(power.getId());
            System.out.println(power.getPowerName());
        }
    }

    @Test
    public void testQueryPowersByPowerName() throws Exception {
        List<Power> powers = powerMapper.queryPowersLikePowerName("测试%");
        for (Power power : powers) {
            System.out.println(power.getPowerName());
        }
    }

    @Test
    public void testCount(){
        System.out.println(powerMapper.count());
    }

    @Test
    public void testQueryPowerById() throws Exception {
        //System.out.println(powerMapper.queryPowerById(6180003).getPowerName());
    }

    @Test(invocationCount = 100,threadPoolSize = 10)
    public void testInser(){
            List<Power> powers = new ArrayList<Power>();
            for (int j = 0; j <1000; j++) {
                powers.add(new Power("测试"  + "a" + j));
            }
            int id = powerMapper.inserBatch(powers);
            sqlSession.commit();
    }

    @AfterClass
    public void tearDown() throws Exception {
        sqlSession.close();
    }

}