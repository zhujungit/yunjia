package com.hp.controller;

import com.hp.domain.Users;
import com.hp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;
@Controller
@Service
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/users")
    @ResponseBody
    public List<Users> getUsers() throws SQLException{
    return usersService.getUsers();
    }

    @RequestMapping("/user/{id}")
    @ResponseBody
    public Users getUserById(@PathVariable("id") int id) throws SQLException{
        return usersService.getUserById(id);
    }

}
