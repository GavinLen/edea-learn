package xyz.eden.learn.springboot.web.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

/**
 * Parame
 *
 * @author gavin
 * @version 1.0
 * @datetime 2021/1/17 22:16
 */
public class Parameterized {

@ParameterizedTest
@DisplayName(value = "参数化测试")
@ValueSource(ints = {1, 2, 3, 4})
public void test(Integer id) {
    System.out.println("通过" + id + "查询");
}
}
