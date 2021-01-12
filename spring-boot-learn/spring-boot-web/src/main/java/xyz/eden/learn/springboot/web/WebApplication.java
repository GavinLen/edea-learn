package xyz.eden.learn.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Stream;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/4 20:15
 */
@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(WebApplication.class, args);
//        String[] nameArr = applicationContext.getBeanDefinitionNames();
//        Stream.of(nameArr).forEach(name -> {
//            System.out.println(name);
//        });
    }
}
