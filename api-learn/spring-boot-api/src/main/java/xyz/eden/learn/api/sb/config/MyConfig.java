package xyz.eden.learn.api.sb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.eden.learn.api.sb.entity.PetEntity;
import xyz.eden.learn.api.sb.entity.UserEntity;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/12 21:02
 */
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    @Bean
    public UserEntity userEntity() {
        return new UserEntity();
    }

    @Bean(name = "tom")
    public PetEntity petEntity() {
        return new PetEntity(1L, "tomcat");
    }
}
