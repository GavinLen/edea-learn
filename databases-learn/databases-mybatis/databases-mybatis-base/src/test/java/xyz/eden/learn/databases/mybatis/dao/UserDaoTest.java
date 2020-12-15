package xyz.eden.learn.databases.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import xyz.eden.learn.databases.common.entity.UserEntity;

public class UserDaoTest extends BaseTest {

    @Test
    public void addUser() {

    }

    @Test
    public void getUserById() {
        final SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        UserEntity userEntity = userDao.getUserById(1L);

        Assert.assertNotNull(userEntity);
    }

    @Test
    public void get() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserEntity userEntity = sqlSession.selectOne("xyz.eden.learn.databases.mybatis.dao.UserDao.getUserById", 1);
            Assert.assertNotNull(userEntity);
        }
    }
}