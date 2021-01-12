package xyz.eden.learn.springboot.web.service;

import xyz.eden.learn.springboot.web.entity.UserEntity;

import java.util.List;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/11 17:47
 */
public interface IUserService {

    /**
     * 通过 id 获取
     *
     * @param id
     * @return
     */
    UserEntity getUserById(Long id);

    /**
     * 获取全部
     *
     * @return
     */
    List<UserEntity> getUserList();

}
