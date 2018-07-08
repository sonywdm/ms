package com.renhang.springcloudlesson3configclient.web.controller;

import com.renhang.springcloudlesson3configclient.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heng.jia
 * @date 2018/7/2 下午5:38
 */
@RestController
@EnableConfigurationProperties(User.class)
public class UserController {

    //通过构造器注入
    private final User user;

    @Autowired
    public UserController(User user) {
        this.user = user;
    }

    @GetMapping("/user")
    public User user() {
        return user;
    }
}
