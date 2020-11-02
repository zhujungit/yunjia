package com.hp.dao;

import com.hp.pojo.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//数据库持久层
public class UsersDao {
    //查询所有users表的操作
    public List<Users> getUsers() throws Exception{
        List<Users> list=new ArrayList<>();
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql:///maven?useSSL=false","root","123456");
        //3.获取pstm对象
        PreparedStatement pstm = connection.prepareStatement("select *from users ");
        //4.执行查询
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集

        while (rs.next()){
            Users users=new Users();
            users.setId(rs.getInt("id"));
            users.setAge(rs.getInt("age"));
            users.setName(rs.getString("name"));
            list.add(users);

        }
        return list;
    }
}
