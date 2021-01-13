package xyz.eden.learn.api.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;
import xyz.eden.learn.api.sb.config.MyConfig;
import xyz.eden.learn.api.sb.entity.UserEntity;

import java.util.Arrays;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/12 20:45
 */
@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ApiApplication.class, args);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);

        System.out.println("----------华丽分割线----------");
        MyConfig myConfig = applicationContext.getBean(MyConfig.class);
        UserEntity userEntityByMethod = myConfig.userEntity();

        UserEntity userEntityByContext = applicationContext.getBean(UserEntity.class);
        System.out.println(userEntityByMethod == userEntityByContext);

    }
}
