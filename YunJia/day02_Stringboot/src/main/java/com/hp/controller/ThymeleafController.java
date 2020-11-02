package com.hp.controller;

import com.hp.domain.Users;
import com.hp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Controller
public class ThymeleafController {
    @Autowired
    private UsersService usersService;



    @RequestMapping("/usersth")
    public String getUsers(Model model) throws SQLException {
        List<Users> users=usersService.getUsers();
       model.addAttribute("users",users);
        return "hello";
    }

    @RequestMapping("/helloth")
    public String helloTh(Model model) {
        //model相当于web中的request

        model.addAttribute("name", "曹操");
        return "hello";

    }
    @RequestMapping("/login")
    @ResponseBody
    public String login(String name){
        System.out.println(name);
        if(name.equals("tom")){
            return "登录成功";
        }else{
            return "登录失败";
        }
    }
}
