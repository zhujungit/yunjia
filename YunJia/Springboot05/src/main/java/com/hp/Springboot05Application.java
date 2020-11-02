package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.hp.mapper")
@SpringBootApplication
public class Springboot05Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot05Application.class, args);
    }

}
