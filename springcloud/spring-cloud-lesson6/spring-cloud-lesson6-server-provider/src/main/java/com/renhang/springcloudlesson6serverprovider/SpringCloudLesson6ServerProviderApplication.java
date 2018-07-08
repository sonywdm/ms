package com.renhang.springcloudlesson6serverprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudLesson6ServerProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudLesson6ServerProviderApplication.class, args);
	}
}
