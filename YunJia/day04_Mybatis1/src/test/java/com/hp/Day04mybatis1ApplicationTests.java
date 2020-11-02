package com.hp;

import com.hp.mapper.UsersMapper;
import com.hp.mapper.UsersMapperTK;
import com.hp.mapper.UsersMapperXml;
import com.hp.pojo.Users;
import com.hp.pojo.UsersTK;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;

@SpringBootTest

class Day04mybatis1ApplicationTests {
    @Autowired//spring容器找ds对象
    private DataSource dataSource;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UsersMapperXml usersMapperXml;
    @Autowired
    private UsersMapperTK usersMapperTK;

    @Test
    void testPageth() throws SQLException{
        Example example=new Example(UsersTK.class);//示例对象
        Example.Criteria criteria=example.createCriteria();
        criteria.andLike("username","%tom%");
       // criteria.andGreaterThan("id","2");
        UsersTK usersTK= usersMapperTK.selectByPrimaryKey(3);
        usersMapperTK.selectByExample(example);
        System.out.println(usersTK);
    }

    @Test
    void testPagexml() throws SQLException{
        HashMap<String,Integer> map=new HashMap<>();
        map.put("start",1);
        map.put("size",5);
        System.out.println(usersMapperXml.getUsersByPage(map));
    }



    @Test
    //测输出表
    void  testUsers() throws SQLException{
        System.out.println(usersMapper.getUsers());
    }
    @Test
    //测
    void testDs() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
    //测查找id为1
    @Test
    void testUser() throws SQLException {
        System.out.println(usersMapper.getUsersById(1));
    }

    @Test//插入
    void testadd() throws SQLException {
        Users users=new Users();
        users.setId(12);
        users.setUsername("曹操");
        users.setPassword("1234");
        System.out.println(usersMapper.addUsers(users));
    }
    @Test
    void testPage() throws SQLException {
        System.out.println(usersMapper.getUsersPage(0,1));
    }

}
