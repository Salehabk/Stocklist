package com.qa.stocklist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@EnableConfigurationProperties
@EntityScan

@SpringBootApplication
public class SalehasBakeryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalehasBakeryApplication.class, args);
	}
	 
}
