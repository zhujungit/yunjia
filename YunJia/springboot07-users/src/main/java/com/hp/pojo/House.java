package com.hp.pojo;

import lombok.Data;

//House
@Data
public class House {
    private Integer hid;
    private Users users;//关联user_id
    private District district;//关联district_id
    private HouseType houseType;//关联type_id

    private Double price;
    private Double areas;
    private String title;
    private String mark;
    private String equipment;
    private String address;
    private String imgs;
}