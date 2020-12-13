package xyz.eden.learn.mybatis.base.dao;


import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import xyz.eden.learn.databases.common.entity.UserEntity;
import xyz.eden.learn.databases.mybatis.base.dao.UserDao;

public class UserDaoTest extends BaseTest {

    @Test
    public void testSimple() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            final UserEntity userEntity = sqlSession.selectOne("xyz.eden.learn.databases.mybatis.base.dao.UserDao.getUserById", "1");
            Assert.assertNotNull(userEntity);
            System.out.println(userEntity.toString());
        }
    }

    @Test
    public void getUserById() {
        try (final SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            UserEntity userEntity = userDao.getUserById(1L);
            Assert.assertNotNull(userEntity);
            System.out.println(userEntity.toString());
        }

    }


}