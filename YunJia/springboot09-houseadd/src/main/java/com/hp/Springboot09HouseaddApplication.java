package com.hp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.hp.mapper")
public class Springboot09HouseaddApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09HouseaddApplication.class, args);
    }

}
