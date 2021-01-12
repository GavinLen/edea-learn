package xyz.eden.learn.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试矩阵变量
 *
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/8 18:54
 */
@Slf4j
@RestController
@RequestMapping(value = "mv")
public class MatrixVariableController {


/**
 * 语法2: /boss/1;age=20/2;age=30;age=40;age=50
 * 如果不同的路径中的值, 则需要通过 pathVar 指定路径
 *
 * @return
 */
@GetMapping(value = "boss/{bossId}/{empId}")
public Map<String, Object> getValBy(@PathVariable(value = "bossId") Integer bossId,
                                    @MatrixVariable(value = "age", pathVar = "bossId") Integer boosAge,
                                    @PathVariable(value = "empId") Integer empId,
                                    @MatrixVariable(value = "age", pathVar = "empId") List<Integer> empAgeList) {
    Map<String, Object> map = new HashMap<>();
    map.put("bossId", bossId);
    map.put("boosAge", boosAge);
    map.put("empId", empId);
    map.put("empAgeList", empAgeList);
    return map;
}

/**
 * 语法1: /path;low=34;brand=byd,audi,yd
 *
 * @param path
 * @return
 */
@GetMapping(value = "/{path}")
public Map<String, Object> getValBySimple(@PathVariable(value = "path") String path,
                                          @MatrixVariable(value = "low") Integer low,
                                          @MatrixVariable(value = "brand") List<String> brandList) {
    Map<String, Object> map = new HashMap<>();
    map.put("low", low);
    map.put("brandList", brandList);
    map.put("path", path);

    return map;
}
}
