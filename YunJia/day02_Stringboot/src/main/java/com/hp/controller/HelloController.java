package com.hp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//所有类，层次不能超过启动类
@Controller//实例化（创建对象）当前类，将对象存进spring容器中，

public  class HelloController {

//    如果方法返回值为String类型的话，默认把字符串当成一个页面文件名
    @RequestMapping("/hello")
    @ResponseBody//不做页面，单纯的响应一个字符串
    public String hello(){
        return "你好呀 boot兄弟";
    }
}
