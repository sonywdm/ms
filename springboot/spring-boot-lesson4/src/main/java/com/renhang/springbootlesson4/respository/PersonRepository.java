package com.renhang.springbootlesson4.respository;

import com.renhang.springbootlesson4.entity.Person;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author heng.jia
 * @date 2018/6/30 下午4:54
 */
@NoRepositoryBean
public interface PersonRepository {

    @Cacheable(cacheNames = "persons")
    Person findPerson(String id);


    @CacheEvict(cacheNames = "persons", allEntries = true)
    boolean savePerson(Person person);

}
