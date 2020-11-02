package com.hp.mapper;
import com.hp.pojo.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper {
    @Select("select * from h_users")
    List<Users> selectAll();
    //房东
    @Select("select * from h_users")
    List<Users> selectLandlord();
}

