package com.renhang.springbootlesson4.respository.impl;

import com.renhang.springbootlesson4.entity.Person;
import com.renhang.springbootlesson4.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heng.jia
 * @date 2018/6/30 下午4:55
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final Map<String, Person> repository = new HashMap<>();

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Person findPerson(String id) {
        return (Person) redisTemplate.opsForValue().get(id);
    }

    @Override
    public boolean savePerson(Person person) {
        redisTemplate.opsForValue().set(person.getId(), person);
//        return repository.putIfAbsent(person.getId(), person) == null;
        return true;
    }

}
