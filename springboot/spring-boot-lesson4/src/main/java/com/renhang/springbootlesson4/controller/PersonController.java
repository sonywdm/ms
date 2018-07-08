package com.renhang.springbootlesson4.controller;

import com.renhang.springbootlesson4.entity.Person;
import com.renhang.springbootlesson4.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author heng.jia
 * @date 2018/6/30 下午5:01
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @PostMapping("/save")
    public Person save(@RequestBody Person person) {

        repository.savePerson(person);

        return person;

    }


    @GetMapping("/get/{id}")
    public Person get(@PathVariable String id) {

        return repository.findPerson(id);

    }


}
