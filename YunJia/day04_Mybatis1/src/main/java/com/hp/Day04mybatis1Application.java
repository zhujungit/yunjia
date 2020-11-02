package com.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

//扫描mapper包，@selesc才能生效

@SpringBootApplication
@MapperScan("com.hp.mapper")
public class Day04mybatis1Application {

    public static void main(String[] args) {
        SpringApplication.run(Day04mybatis1Application.class, args);
    }

}
