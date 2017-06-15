package com.shroke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.shroke.mapper")
public class NeilApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeilApplication.class, args);
	}
}
