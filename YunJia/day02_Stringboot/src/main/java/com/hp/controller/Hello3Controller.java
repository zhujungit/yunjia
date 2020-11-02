package com.hp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello3Controller {
   @RequestMapping("/hehe")//适应get  post
    public String hehe(){
        return "hello,boot";
    }
    @GetMapping("/hehe1")//get请求，浏览器地址栏输入网址
    public String hehe1(){
        return "hello1,boot";
    }
    @PostMapping("/hehe2")//post请求，通过html中的form表单的action属性请求
    public String hehe2(){
        return "hello2,boot";
    }
}
