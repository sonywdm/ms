package com.renhang.springbootlesson3.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author heng.jia
 * @date 2018/6/30 下午3:28
 */
@Entity(name = "user")
public class JpaUser {
    @Id
    private Integer id;

    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
