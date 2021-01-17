package xyz.eden.learn.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.eden.learn.springboot.web.entity.UserEntity;
import xyz.eden.learn.springboot.web.service.IUserService;

import javax.annotation.Resource;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/11 18:57
 */
@SpringBootTest
public class BaseTest {
    @Resource
    private IUserService userService;

    @Test
    public void getUserById() {
        UserEntity userEntity = userService.getUserById(1L);
    }

}
