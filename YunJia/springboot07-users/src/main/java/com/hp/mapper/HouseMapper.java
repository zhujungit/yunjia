package com.hp.mapper;

import com.hp.mapper.provider.HouseProvider;
import com.hp.pojo.House;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;


public interface HouseMapper {
    @Select("select h.*,u.*,d.*,t.* from h_house h ,h_district d,h_type t,h_users u where h.user_id=u.uid and h.district_id=d.did and h.type_id=t.typeid order by hid")
    @Results(id = "houseMap",value = {
            //users表
            @Result(column = "uid", property = "users.uid"),
            @Result(column = "name", property = "users.name"),
            @Result(column = "psw", property = "users.psw"),
            @Result(column = "psw", property = "users.psw"),
            @Result(column = "sex", property = "users.sex"),
            @Result(column = "birth", property = "users.birth"),
            @Result(column = "headImg", property = "users.headImg"),
            @Result(column = "role", property = "users.role"),
            //district表
            @Result(column = "did", property = "district.did"),
            @Result(column = "parentId", property = "district.parentId"),
            @Result(column = "dis_name", property = "district.disName"),
            //type表
            @Result(column = "typeid", property = "houseType.typeid"),
            @Result(column = "typedesc", property = "houseType.typedesc"),
    })
    List<House> selectAll();
    @Insert("insert into h_house values(null,#{user_id},#{district_id},#{type_id},#{price},#{areas},#{title},#{mark},#{equipment},#{address},#{imgs})")
    void addHouse(House house);
@SelectProvider(type = HouseProvider.class,method = "selectByCondition")
@ResultMap("houseMap")
List<House> selectByCondition(HashMap<String, String> condition);
}
