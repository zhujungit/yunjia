package com.hp.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hp.mapper.UsersMapper;
import com.hp.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersMapper usersMapper;

    //跳转到show_users页面
    @RequestMapping("/show")
    public String show(Model model,
                       @RequestParam(defaultValue = "1") Integer pageNo,
                       @RequestParam(defaultValue = "3") Integer pageSize){
        System.out.println(pageNo);
        System.out.println(pageSize);

        //1.pageHelper开始分页
        PageHelper.startPage(pageNo,pageSize);
        //2.通用mapper查询所有数据
        List<Users> users = usersMapper.selectAll();

        //3.封装users到pageInfo对象
        PageInfo<Users> usersPage = new PageInfo<>(users);

        System.out.println(usersPage);

        //4.将结果集存进model中
        model.addAttribute("usersPage",usersPage);
        //5.跳转到show_users页面
        return "admin/users/show_users";
    }

}
