package xyz.eden.learn.springboot.simple.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.eden.learn.springboot.simple.entity.Person;

import javax.annotation.Resource;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/26 10:49
 */
@Slf4j
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Resource
    private Person person;

    @GetMapping(value = "person")
    public Person get() {
        return person;
    }

    @GetMapping(value = "str")
    public String getStr() {
        log.info("HelloController.getStr");
        return "str";
    }
}
