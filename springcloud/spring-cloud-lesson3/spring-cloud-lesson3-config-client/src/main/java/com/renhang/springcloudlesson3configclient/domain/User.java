package com.renhang.springcloudlesson3configclient.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author heng.jia
 * @date 2018/7/2 下午5:39
 */
@ConfigurationProperties(prefix = "daocloud.user")
public class User {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}