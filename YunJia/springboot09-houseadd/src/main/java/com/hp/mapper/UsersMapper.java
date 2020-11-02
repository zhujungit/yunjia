package com.hp.mapper;

import com.hp.pojo.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper {
    //selectAll
    @Select("select * from h_users")
    List<Users> selectAll();


    //查询房东方法
    @Select("select * from h_users  where role ='房东'")
    List<Users> selectLandlord();
}
