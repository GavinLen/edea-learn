package xyz.eden.learn.databases.mybatis.dao;

import xyz.eden.learn.databases.common.entity.UserEntity;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/15 9:57
 */
public interface UserDao {

    int addUser(UserEntity userEntity);

    UserEntity getUserById(Long userId);
}
