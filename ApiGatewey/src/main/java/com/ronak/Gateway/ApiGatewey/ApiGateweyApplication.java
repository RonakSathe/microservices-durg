package com.ronak.Gateway.ApiGatewey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGateweyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateweyApplication.class, args);
	}

}
