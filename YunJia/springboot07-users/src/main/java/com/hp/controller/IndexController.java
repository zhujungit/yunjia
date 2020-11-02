package com.hp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

@RequestMapping("/index")
        public String index(){
                //跳转index.html
                return "index";
        }
        //跳转到后台首页
        @RequestMapping("/admin")
        public String admin(){
                //跳转index.html
                return "admin/admin";
        }
        @RequestMapping("/front")
        public String front(){

                return "front/home_index";
        }
        }