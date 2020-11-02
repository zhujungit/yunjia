package com.hp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hp.mapper.UsersMapper;
import com.hp.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersMapper usersMapper;

    @RequestMapping("/users")
    @ResponseBody//异步请求加载数据
    public PageInfo<Users> users(
            @RequestParam(defaultValue = "1") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize
    ) {

        //开始分页
        PageHelper.startPage(pageNo, pageSize);
        //查询所有数据
        List<Users> users = usersMapper.selectAll();
        //封装在PageInfo
        return new PageInfo<Users>(users);
    }

    @RequestMapping("/hello")

    public String hello(Model model) {
        //查询所有users表
        List<Users> users = usersMapper.selectAll();
        //将users集合存进model
        model.addAttribute("users", users);
        return "hello";


    }

    @RequestMapping("/index")

    public String index() {
        return "index";
    }
}
