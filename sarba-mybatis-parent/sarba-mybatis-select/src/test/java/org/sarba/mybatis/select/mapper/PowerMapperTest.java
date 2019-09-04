package org.sarba.mybatis.select.mapper;

import org.apache.ibatis.logging.jdk14.Jdk14LoggingImpl;
import org.apache.ibatis.session.SqlSession;
import org.sarba.mybatis.datasource.MybatiesDataSource;
import org.sarba.mybatis.entity.Power;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class PowerMapperTest {

    private SqlSession sqlSession;
    private PowerMapper powerMapper;

    @BeforeClass
    public void setUp() throws Exception {
      /*获取Hikari连接池连接*/
      sqlSession = MybatiesDataSource.INSTANCE.getHikariSqlSession();
      sqlSession.getConfiguration().setLogImpl(Jdk14LoggingImpl.class);
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
        System.out.println(powerMapper.queryPowers().size());
    }

    @Test
    public void testQueryPowerById() throws Exception {
        System.out.println(powerMapper.queryPowerById(123).getPowerName());
    }

    @Test
    public void testInser(){
        int id = powerMapper.insert(new Power("测试"));
        sqlSession.commit();
    }

    @Test
    public void testCount(){
        System.out.println(powerMapper.count());
    }

    @Test(invocationCount = 800,threadPoolSize = 10)
    public void testInserBacth(){
            List<Power> powers = new ArrayList<Power>();
            for (int j = 0; j <1000; j++) {
                powers.add(new Power("测试" + "a" + j));
            }
            int id = powerMapper.inserBatch(powers);
            sqlSession.commit();

    }

    @AfterClass
    public void tearDown() throws Exception {
        sqlSession.close();
    }
}