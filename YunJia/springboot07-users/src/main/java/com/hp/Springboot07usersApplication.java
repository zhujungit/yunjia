package com.hp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.hp.mapper")
@SpringBootApplication
public class
Springboot07usersApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot07usersApplication.class, args);
	}

}
