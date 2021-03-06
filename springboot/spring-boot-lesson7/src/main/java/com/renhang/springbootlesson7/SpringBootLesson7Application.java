package com.renhang.springbootlesson7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ImportResource(locations = {
		"META-INF/spring/context.xml",
		"META-INF/spring/context-test.xml",
		"META-INF/spring/context-prod.xml"
})
public class SpringBootLesson7Application implements EnvironmentAware{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLesson7Application.class, args);
	}

	@Override
	public void setEnvironment(Environment environment) {
		System.err.println("当前激活的Profiles : " + Arrays.asList(environment.getActiveProfiles()));

		if (environment instanceof ConfigurableEnvironment) {
			ConfigurableEnvironment env = ConfigurableEnvironment.class.cast(environment);

			MutablePropertySources mutablePropertySources = env.getPropertySources();

			Map<String, Object> source = new HashMap<>();

			source.put("server.port", 1234);

			PropertySource propertySource = new MapPropertySource("java-code", source);

			mutablePropertySources.addFirst(propertySource);

		}
	}
}
