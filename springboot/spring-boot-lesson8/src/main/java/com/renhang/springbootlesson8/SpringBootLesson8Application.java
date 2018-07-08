package com.renhang.springbootlesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class SpringBootLesson8Application {

	public static void main(String[] args) {
//		SpringApplication.run(SpringBootLesson8Application.class, args);

		SpringApplication springApplication = new SpringApplication(SpringBootConfiguration.class);
		springApplication.setWebEnvironment(true);
		springApplication.run(args);
	}
}
