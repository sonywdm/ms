package com.renhang.web.controller;

import com.renhang.api.UserService;
import com.renhang.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heng.jia
 * @date 2018/7/3 下午2:57
 */
@RestController
public class UserServiceProviderController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/save")
    public boolean user(@RequestBody User user){
        return userService.saveUser(user);
    }

}
