package com.squirrel.smsfapi;

import com.squirrel.smsfapi.config.AppProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SmsfApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsfApiApplication.class, args);
	}
}