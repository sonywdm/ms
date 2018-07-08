package com.renhang.springbootlesson7.context;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heng.jia
 * @date 2018/7/2 下午12:03
 */
public class CustomizedSpringBootApplicationListener implements
        ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {


    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {

        ConfigurableEnvironment env = event.getEnvironment();

        MutablePropertySources mutablePropertySources = env.getPropertySources();

        Map<String, Object> source = new HashMap<>();

        source.put("server.port", 5678);
        source.put("spring.profiles.include", "abc");

        PropertySource propertySource = new MapPropertySource("from-application-listener", source);

        mutablePropertySources.addFirst(propertySource);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
