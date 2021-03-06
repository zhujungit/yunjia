package com.hp.pojo;

import lombok.Data;

@Data
public class House {
    //1.本身的房源信息
    private Integer hid;
    private Double price;
    private Double areas;
    private String title;
    private String mark;
    private String equipment;
    private String address;
    private String imgs;
    //实现新增，补全原始字段
    private Integer user_id;
    private Integer district_id;
    private Integer type_id;

    //2.关联 用户，区域，类型
    private Users users;
    private District district;
    private Type type;

}
