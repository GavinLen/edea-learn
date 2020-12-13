package xyz.eden.learn.mybatis.base.dao;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xyz.eden.learn.databases.common.entity.UserEntity;
import xyz.eden.learn.databases.mybatis.base.dao.UserDao;

import java.util.Date;
import java.util.Random;

/**
 * CacheTest
 *
 * @author gavin
 * @version 1.0
 * @datetime 2020/12/13 22:24
 */
@Log4j2
public class CacheTest extends BaseTest {

    @Test
    public void addUser() {
        try (final SqlSession sqlSession = sqlSessionFactory.openSession()) {
            final UserDao userDao = sqlSession.getMapper(UserDao.class);
            final int addResult = userDao.addUser(new UserEntity("tam", "tom_1@163.com", new Date()));
            log.info("AddResult:[{}].", addResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserById() {
        try (final SqlSession sqlSession = sqlSessionFactory.openSession()) {
            final UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.getUserById((long) 1);

            final int addResult = userDao.addUser(new UserEntity("tam_" + new Random().nextInt(), "tom_1@163.com", new Date()));

            userDao.getUserById((long) 1);

        }
    }

}
