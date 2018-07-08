package com.renhang.springbootlesson7.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author heng.jia
 * @date 2018/7/2 上午11:53
 */
@ConfigurationProperties("book")
public class Book {

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
