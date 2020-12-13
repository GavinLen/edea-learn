package xyz.eden.learn.databases.mybatis.base.dao;


import xyz.eden.learn.databases.common.entity.UserEntity;

/**
 * UserDao
 *
 * @author gavin
 * @version 1.0
 * @datetime 2020/12/12 19:40
 */
public interface UserDao {

    int addUser(UserEntity userEntity);

    UserEntity getUserById(Long userId);

}
