package xyz.eden.learn.springboot.simple.entity;

import lombok.*;

import java.util.Date;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/29 19:02
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {

    private Long id;
    private String name;
    private String email;
    private Date createDatetime;
}
