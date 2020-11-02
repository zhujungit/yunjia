package com.hp.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Component //实例化某个类即创建某个类的对象，并存进spring的容器中，方便随时取出来使用
@ConfigurationProperties(prefix = "user")
public class User {
    private String username;
    private Integer password;
    private Integer age;
    private Date birth;
    private List hobby;
    private Map account;


}
