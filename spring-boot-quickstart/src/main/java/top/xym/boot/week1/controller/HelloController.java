package top.xym.boot.week1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: HelloController
 * @Date: 2025/9/5
 * @Version: 1.0
 */
@RestController
public class HelloController {
    @Value("${my.feature.helloSwitch}")
    private boolean isHelloEnable;

    @Value("${my.feature.closeMsg}")
    private String closeMessage;

    @GetMapping("/hello")
    public String hello() {
        boolean isOpenEnable;
        if (isHelloEnable) {
            return "接口开放中！欢迎访问我的第一个 Spring Boot 项目~";
        } else  {
            return closeMessage;
        }
    }
}
