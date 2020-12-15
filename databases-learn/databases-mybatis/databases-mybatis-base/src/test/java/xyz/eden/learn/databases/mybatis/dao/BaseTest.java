package xyz.eden.learn.databases.mybatis.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

import java.io.InputStream;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/15 15:48
 */
public class BaseTest {
    protected static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        String configFilePath = "mybatis-config.xml";
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(configFilePath);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
}
