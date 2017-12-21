package com.dby.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TestManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestManagerApplication.class, args);
	}
}
