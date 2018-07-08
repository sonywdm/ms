package com.renhang.springcloudlesson6serverprovider.web.controller;

import com.renhang.springcloudlesson6serverprovider.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heng.jia
 * @date 2018/7/2 下午11:44
 */
@RestController
public class ServiceProviderController {

    @Value("${server.port}")
    private Integer port;

    @PostMapping("/greeting")
    public String greeting(@RequestBody User user) {
        return "Greeting , " + user + " on port : " + port;
    }

}