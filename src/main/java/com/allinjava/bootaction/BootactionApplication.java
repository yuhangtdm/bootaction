package com.allinjava.bootaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.allinjava.bootaction.mapper")
public class BootactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootactionApplication.class, args);
	}

}
