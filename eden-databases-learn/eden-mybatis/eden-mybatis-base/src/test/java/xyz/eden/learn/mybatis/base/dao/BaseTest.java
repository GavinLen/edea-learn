package xyz.eden.learn.mybatis.base.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

import java.io.InputStream;

/**
 * BaseTest
 *
 * @author gavin
 * @version 1.0
 * @datetime 2020/12/13 22:24
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
