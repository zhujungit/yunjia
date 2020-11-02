package com.hp.pojo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "women")
public class Women {
    private String username;
    private String password;
    private int age;
    private Date birth;
    private List hobby;
    private Map account;
    private Pet pet;

}
