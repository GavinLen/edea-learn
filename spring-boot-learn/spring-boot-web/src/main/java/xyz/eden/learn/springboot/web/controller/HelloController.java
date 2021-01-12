package xyz.eden.learn.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.eden.learn.springboot.web.entity.UserEntity;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/5 19:47
 */
@Slf4j
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @PostMapping(value = "user")
    public String getUser(UserEntity userEntity) {
        log.info(userEntity.toString());
        return "userEntity";
    }

    @GetMapping(value = "success")
    public String success(Map<String, Object> map,
                          Model model,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        log.info("map", map.get("map"));
        log.info("model", model.getAttribute("model"));
        log.info("request", request.getAttribute("request"));

        return "success";
    }

    @GetMapping("param")
    public String param(Map<String, Object> map,
                        Model model,
                        HttpServletRequest request,
                        HttpServletResponse response) {

        map.put("map", "map");
        model.addAttribute("model", "model");
        request.setAttribute("request", "request");
        response.addCookie(new Cookie("cookie", "cookie"));

        return "forward:/hello/success";
    }


    @GetMapping(value = "str")
    public String getStr(HttpServletRequest request) {
        return "success";
    }

}
