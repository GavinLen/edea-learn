package xyz.eden.learn.api.core;

import lombok.Data;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/4 16:15
 */
@Data
public class ResultExt<T> extends Result {
    private Long timestamp;

}
