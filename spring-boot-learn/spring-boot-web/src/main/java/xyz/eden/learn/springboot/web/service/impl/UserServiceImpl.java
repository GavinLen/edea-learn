package xyz.eden.learn.springboot.web.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import xyz.eden.learn.springboot.web.entity.UserEntity;
import xyz.eden.learn.springboot.web.service.IUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/11 18:54
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
public class UserServiceImpl implements IUserService {
    @Override
    public UserEntity getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserEntity> getUserList() {
        log.info("getUserList");

        List<UserEntity> entityList = new ArrayList<>(10);
        UserEntity userEntity;
        for (int i = 0; i < 10; i++) {
            userEntity = this.getUserById(Long.valueOf(i));

            entityList.add(userEntity);
        }
        return entityList;
    }
}
