package xyz.eden.learn.springboot.simple.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.eden.learn.springboot.simple.entity.UserEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/29 19:03
 */
@Slf4j
@RestController
@RequestMapping(value = "user")
public class UserController {

    @GetMapping(value = "")
    public List<UserEntity> getUser() {
        log.info("Get All User Info.");
        List<UserEntity> userEntityList = new ArrayList<>(10);
        String userName = "tom";
        for (int i = 0; i < 10; i++) {
            userName += i;
            userEntityList.add(new UserEntity(Long.valueOf(i), userName, userName + "@", new Date()));
        }

        return userEntityList;
    }

    @GetMapping(value = "{id}")
    public UserEntity getUserById(@PathVariable("id") Long userId) {
        log.info("Get UserEntity By Id [{}].", userId);
        String username = "tom_" + userId;
        UserEntity userEntity = new UserEntity(userId, username, username + "@", new Date());
        log.info("UserEntity:{}.", userEntity.toString());
        return userEntity;
    }

}
