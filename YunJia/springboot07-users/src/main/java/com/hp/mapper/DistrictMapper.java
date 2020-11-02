package com.hp.mapper;

import com.hp.pojo.District;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DistrictMapper {
    @Select("SELECT * FROM h_district WHERE parentId=#{did}")
  @Results(@Result(column = "dis_name",property = "disName"))
    List<District> getDisByParentId(Integer did);
}
