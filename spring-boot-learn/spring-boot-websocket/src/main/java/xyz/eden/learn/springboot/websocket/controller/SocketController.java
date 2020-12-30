package xyz.eden.learn.springboot.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.eden.learn.springboot.websocket.service.WebSocketServer;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/29 20:23
 */
@Controller
public class SocketController {
    @Autowired
    private WebSocketServer webSocketServer;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/webSocket")
    public ModelAndView socket() {
        ModelAndView mav = new ModelAndView("/webSocket");
        return mav;
    }
}
