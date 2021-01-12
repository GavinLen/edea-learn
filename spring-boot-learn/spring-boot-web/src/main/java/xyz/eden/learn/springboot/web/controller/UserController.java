package xyz.eden.learn.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/5 20:32
 */
@Slf4j
@RequestMapping(value = "user")
@RestController
public class UserController {

    @DeleteMapping(value = "")
    public String delUser() {
        return "delUser";
    }

    @PutMapping(value = "")
    public String updateUser(@RequestAttribute(value = "id") String id) {
        return "updateUser";
    }

    @PostMapping(value = "")
    public Boolean saveUser(@RequestBody Map<String, String> map) {
        System.out.println(map);
        return Boolean.TRUE;
    }

    /**
     * @return
     */
    @GetMapping(value = "/mv/{typeId}/{empId}")
    public Map<String, String> getValByPath() {
        return null;
    }

    /**
     * 语法1:/mv/{path};low=34;brand=byd,audi,yd
     *
     * @return
     */
    @GetMapping(value = "mv/{path}")
    public Map<String, Object> getValByR(@PathVariable(value = "path") String path,
                                         @MatrixVariable(value = "low") Integer low,
                                         @MatrixVariable(value = "brand") List<String> brandList) {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brandList", brandList);
        map.put("path", path);

        return map;
    }

    @GetMapping(value = "")
    public String getUser() {
        return "getUser";
    }

}
