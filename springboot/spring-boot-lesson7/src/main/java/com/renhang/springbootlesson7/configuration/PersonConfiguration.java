package com.renhang.springbootlesson7.configuration;

import com.renhang.springbootlesson7.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author heng.jia
 * @date 2018/7/2 上午11:54
 */
@Configuration
public class PersonConfiguration {

    @Bean
    @Profile("prod")
    public Person renhang() {
        Person person = new Person();
        return person;
    }

    @Bean
    @Profile("test")
    public Person google() {
        Person person = new Person();
        return person;
    }

}
