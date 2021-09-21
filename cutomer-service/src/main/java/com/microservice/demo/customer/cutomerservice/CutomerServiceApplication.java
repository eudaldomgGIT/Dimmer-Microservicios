package com.microservice.demo.customer.cutomerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CutomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CutomerServiceApplication.class, args);
	}

}
