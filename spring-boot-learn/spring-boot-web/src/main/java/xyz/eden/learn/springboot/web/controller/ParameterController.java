package xyz.eden.learn.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/6 20:42
 */
@Slf4j
@RestController
@RequestMapping(value = "Parameter")
public class ParameterController {

    @PostMapping(value = "add")
    public Boolean addCar(@RequestBody Map<String, String> map) {
        map.entrySet().forEach(item -> {
            System.out.println(item + " -> " + map.get(item));
        });

        return Boolean.TRUE;
    }

    @GetMapping(value = "car")
    public Map<String, Object> getParameterByP(@RequestParam(value = "id") Long id,
                                               @RequestParam(value = "name") String name,
                                               @CookieValue Cookie cookie,
                                               @CookieValue(value = "_ga") String ga) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("ga", ga);
        map.put("timestamp", new Date().toString());
        System.out.println(cookie.getName() + "->" + cookie.getValue());
        return map;
    }

    @GetMapping(value = "/car/{id}")
    public Map<String, String> getParameterByPath(@PathVariable(value = "id") Long id,
                                                  @PathVariable Map<String, String> map,
                                                  @RequestHeader HttpHeaders httpHeaders) {
        map.put("id", id.toString());
        map.put("timestamp", new Date().toString());
        Map<String, String> stringStringMap = httpHeaders.toSingleValueMap();
        map.putAll(stringStringMap);

        return map;
    }

}
