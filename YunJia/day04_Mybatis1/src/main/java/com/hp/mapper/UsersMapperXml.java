package com.hp.mapper;

import com.hp.pojo.Users;

import java.util.List;
import java.util.Map;

public interface UsersMapperXml {

    List<Users> getUsers();
    Users getUsersById(int id);
    int addUsers(Users users);
    List<Users> getUsersByPage(Map map);
}
