package com.renhang.springbootlesson1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class SpringBootLesson1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLesson1Application.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@GetMapping("rest")
	Map<String, Object> rest(){
		Map<String, Object> map = new HashMap<>();

		map.put("1", "a");
		map.put("2", 2);

		return map;
	}
}
