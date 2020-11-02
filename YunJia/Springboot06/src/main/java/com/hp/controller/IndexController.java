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
        }