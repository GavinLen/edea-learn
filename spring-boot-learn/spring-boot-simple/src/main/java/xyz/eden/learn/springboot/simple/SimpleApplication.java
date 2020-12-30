package xyz.eden.learn.springboot.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/24 15:03
 */
@Slf4j
@SpringBootApplication
public class SimpleApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SimpleApplication.class);
        String[] beanNameArr = applicationContext.getBeanDefinitionNames();
        Arrays.asList(beanNameArr).stream().forEach((beanName) -> {
            System.out.println(beanName);
        });

    }
}
