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
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersMapper usersMapper;

    @RequestMapping("/show")
    public String show(Model model,
                       @RequestParam(defaultValue = "1") Integer pageNo,
                       @RequestParam(defaultValue = "3") Integer pageSize){
        //1.分页查询
        PageHelper.startPage(pageNo,pageSize);
        List<Users> users = usersMapper.selectAll();


        PageInfo<Users> usersPage = new PageInfo<>(users);
        //2.存进model
        model.addAttribute("usersPage",usersPage);
        //3.跳转到users下的show页面
        return "admin/users/show_users";
    }

}