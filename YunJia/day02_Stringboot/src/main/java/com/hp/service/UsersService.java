package com.hp.service;

import com.hp.dao.UsersDao;
import com.hp.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service  //与其一样  可在config中创对象 实例化
public class UsersService {
    @Autowired
    private UsersDao usersDao;
    public List<Users> getUsers() throws SQLException{
        return usersDao.getUsers();
    }

    public Users getUserById(int id) throws SQLException {
        //调用service
        return usersDao.getUserById(id);
    }



}
