package com.renhang.springcloudlesson6serverconsumer.web.controller;

import com.renhang.springcloudlesson6serverconsumer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author heng.jia
 * @date 2018/7/2 下午11:47
 */
@RestController
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${serivce-provider.host}")
    private String serviceProviderHost;

    @Value("${serivce-provider.port}")
    private Integer serviceProviderPort;

    @Value("${serivce-provider.name}")
    private String serviceProviderName;


    @GetMapping("")
    public String index() {
        User user = new User();
        user.setId(1L);
        user.setName("daocloud");
//        return restTemplate.postForObject("http://" +
//                        serviceProviderHost + ":" + serviceProviderPort +
//                        "/greeting",
//                user, String.class);

        return restTemplate.postForObject("http://" +
                        serviceProviderName +
                        "/greeting",
                user, String.class);
    }

}

