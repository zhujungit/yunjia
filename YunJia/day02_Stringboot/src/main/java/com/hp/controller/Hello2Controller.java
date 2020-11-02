package com.hp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody//类上，整个类所有方法，相当于加上该注解
@Controller
@RestController//集成
public class Hello2Controller {
    @RequestMapping("/haha")

    public String haha() {
        return "哈哈，boot兄弟";
    }
    @RequestMapping("/haha1")
    public String haha1() {
        return "哈哈1，boot兄弟";
    }
}
