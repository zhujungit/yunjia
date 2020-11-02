package com.hp.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="users")

public class UsersTK {

@KeySql(useGeneratedKeys =true)//可将自动生成主键
    private int id;
    private String username;
    private String password;
}
