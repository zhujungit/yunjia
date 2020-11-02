package com.hp.mapper;

import com.hp.mapper.provider.HouseProvider;
import com.hp.pojo.House;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface HouseMapper {

    @Select("SELECT * FROM h_house h,h_users u,h_district d,h_type t  WHERE h.user_id=u.uid  AND h.district_id=d.did AND h.type_id=t.typeid order by hid ")
    @Results({
            //手动封装users表数据
            @Result(column = "uid",property = "users.uid"),
            @Result(column = "name",property = "users.name"),
            @Result(column = "psw",property = "users.psw"),
            @Result(column = "sex",property = "users.sex"),
            @Result(column = "birth",property = "users.birth"),
            @Result(column = "headImg",property = "users.headImg"),
            @Result(column = "role",property = "users.role"),
            //district表
            @Result(column = "did",property = "district.did"),
            @Result(column = "parentId",property = "district.parentId"),
            @Result(column = "dis_name",property = "district.disName"),
            //type表
            @Result(column = "typeid",property = "type.typeid"),
            @Result(column = "typedesc",property = "type.typedesc")

    })
    List<House> selectAll();


    @Insert("insert into h_house values(null,#{user_id},#{district_id},#{type_id},#{price},#{areas},#{title},#{mark},#{equipment},#{address},#{imgs})")
    void addHouse(House house);

    //条件查询
    @SelectProvider(type = HouseProvider.class,method = "selectByQuery")
    @ResultMap("houseMap")//引用上面的 @Results
    List<House> selectByQuery(Map<String, String> query);
}
