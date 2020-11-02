package com.hp.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
public class Pet {
    String name;
    int age;
    String type;

}
