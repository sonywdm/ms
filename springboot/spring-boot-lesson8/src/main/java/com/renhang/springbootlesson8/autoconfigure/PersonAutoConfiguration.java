package com.renhang.springbootlesson8.autoconfigure;

import com.renhang.springbootlesson8.domain.Person;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author heng.jia
 * @date 2018/7/2 下午2:21
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "person", name = "enabled", havingValue = "true")
@AutoConfigureAfter(EmbeddedServletContainerAutoConfiguration.class)
public class PersonAutoConfiguration {

    @ConfigurationProperties(prefix = "person")
    @Bean
    public Person person(){
        return new Person();
    }

}
