package com.renhang.springcloudlesson5configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudLesson5ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudLesson5ConfigServerApplication.class, args);
	}
}
