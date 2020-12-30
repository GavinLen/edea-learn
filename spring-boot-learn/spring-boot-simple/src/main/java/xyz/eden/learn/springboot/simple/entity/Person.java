package xyz.eden.learn.springboot.simple.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/29 19:39
 */
@Component
@ConfigurationProperties(value = "person")
@Data
public class Person {
    private Long id;
    private String userName;
    private Boolean boss;
    private Date birth;
    private Pel pel;
    private String[] interestArr;
    private List<String> animalList;
    private Map<String, Object> score;
    private Set<Double> salarySet;
    private Map<String, List<Pel>> allPelMap;
}
