package xyz.eden.learn.springboot.simple.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/29 19:44
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "user")
public class PersonConfig {

    private Long id;
    private String name;

}
