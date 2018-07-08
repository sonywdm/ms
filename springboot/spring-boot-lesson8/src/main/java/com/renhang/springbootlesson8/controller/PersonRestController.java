package com.renhang.springbootlesson8.controller;

import com.renhang.springbootlesson8.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heng.jia
 * @date 2018/7/2 下午2:20
 */
@RestController
public class PersonRestController {

    private final Person person;

    public PersonRestController(Person person){
        this.person = person;
    }

    @GetMapping("/person")
    public Person person(){
        return person;
    }

}
