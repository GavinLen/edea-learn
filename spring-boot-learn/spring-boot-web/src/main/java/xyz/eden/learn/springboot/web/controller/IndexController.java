package xyz.eden.learn.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/5 19:24
 */
@Slf4j
@RequestMapping(value = "index")
public class IndexController {

    @GetMapping(value = "")
    public ModelAndView toIndex() {
        return new ModelAndView("index");
    }
}
