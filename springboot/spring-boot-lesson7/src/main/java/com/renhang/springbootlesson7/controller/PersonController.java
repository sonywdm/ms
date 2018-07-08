package com.renhang.springbootlesson7.controller;

import com.renhang.springbootlesson7.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author heng.jia
 * @date 2018/7/2 上午10:16
 */
@RestController
public class PersonController implements EnvironmentAware{

    @Autowired
//    @Qualifier("person")
    private Person person;

    @Value("${person.id}")
    private Long id;

    @Value("${person.name:daocloud}")
    private String name;

    private Integer age;

    @GetMapping("/person/daocloud")
    public Person xiaomage(){
        return person;
    }

    @GetMapping("/person/daocloud/data")
    public Map<String, Object> daocloudData(){
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("id", id);
        data.put("name", name);
        data.put("age", age);
        return data;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.age = environment.getProperty("person.age", Integer.class);
    }
}
