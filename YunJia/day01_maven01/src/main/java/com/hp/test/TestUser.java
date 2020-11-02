package com.hp.test;

import com.hp.dao.UsersDao;
import com.hp.pojo.Users;
import org.junit.Test;

import java.util.List;

public class TestUser {
    @Test
    public void testUser() throws Exception {
        UsersDao usersDao=new UsersDao();
        List<Users> users = usersDao.getUsers();
        System.out.println(users);
    }
}
