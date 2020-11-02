package com.hp.mapper;

import com.hp.pojo.House;
import com.hp.pojo.HouseType;
import com.hp.pojo.Users;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.Type;
import java.util.List;

public interface TypeMapper {
    //selectAll
    @Select("select * from h_type")
    List<HouseType> selectAll();
}
