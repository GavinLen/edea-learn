package xyz.eden.learn.api.sb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/12 21:05
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PetEntity {
    private Long id;
    private String name;
}
