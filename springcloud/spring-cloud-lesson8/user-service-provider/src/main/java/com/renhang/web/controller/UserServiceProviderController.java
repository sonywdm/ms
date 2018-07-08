package com.renhang.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.renhang.api.UserService;
import com.renhang.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * @author heng.jia
 * @date 2018/7/3 下午2:57
 */
@RestController
public class UserServiceProviderController {
    @Autowired
    private UserService userService;

    private final static Random random = new Random();

    @PostMapping("/user/save")
    public boolean user(@RequestBody User user){
        return userService.saveUser(user);
    }

    /**
     * 获取所有用户列表
     *
     * @return
     */
    @HystrixCommand(
            commandProperties = { // Command 配置
                    // 设置操作时间为 100 毫秒
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            },
            fallbackMethod = "fallbackForGetUsers" // 设置 fallback 方法
    )
    @GetMapping("/user/list")
    public Collection<User> getUsers() throws InterruptedException {

        long executeTime = random.nextInt(200);

        // 通过休眠来模拟执行时间
        System.out.println("Execute Time : " + executeTime + " ms");

        Thread.sleep(executeTime);

        return userService.findAll();
    }

    /**
     * {@link #getUsers()} 的 fallback 方法
     *
     * @return 空集合
     */
    public Collection<User> fallbackForGetUsers() {
        return Collections.emptyList();
    }

}
