package com.hp.mapper;


import com.hp.projo.Smbms_User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper {
    //selectAll
    @Select("select * from smbms_user")
    List<Smbms_User> selectAll();


}
