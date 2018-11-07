package com.fei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fei.mapper")
public class CrawlerdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrawlerdataApplication.class, args);
	}
}
