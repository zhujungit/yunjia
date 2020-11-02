package com.hp.mapper;

import com.hp.pojo.Users;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
//注解版
public interface UsersMapper {
    @Select("select *from users")
    //接口的抽象方法
    List<Users> getUsers();
    @Select("select * from users where id=#{id}")
    Users getUsersById(int id);

    @Insert("insert into users values(#{id},#{username},#{password})")
    int addUsers(Users users);

    @Select("select *from users limit #{start},#{size}")
    List<Users> getUsersPage(int start,int size);

}
