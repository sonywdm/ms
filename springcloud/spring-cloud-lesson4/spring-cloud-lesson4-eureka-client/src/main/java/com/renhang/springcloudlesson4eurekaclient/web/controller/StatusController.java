package com.renhang.springcloudlesson4eurekaclient.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heng.jia
 * @date 2018/7/2 下午9:16
 */
@RestController
public class StatusController {

    @GetMapping("/status")
    public String status() {
        return "OK";
    }

}
