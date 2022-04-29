package com.side.anitime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class AnitimeApplication extends SpringBootServletInitializer 
{
	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AnitimeApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AnitimeApplication.class, args);
	}


}
