package xyz.eden.learn.springboot.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/11 17:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    private Long id;
    private String name;

}
