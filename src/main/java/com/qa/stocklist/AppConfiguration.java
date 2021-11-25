package com.qa.stocklist;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfiguration {

	   
	@Bean
	public LocalDate timeNow() {
		return LocalDate.now();
	}
	
}