package com.hp.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data

public class Users {

    private Integer uid;
    private String name;
    private String psw;
    private String sex;
    private Date birth;

    private String headImg;
    private String role;
}
