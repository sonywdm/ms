package com.renhang.springbootlesson2.service.impl;

import com.renhang.springbootlesson2.dto.User;
import com.renhang.springbootlesson2.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author heng.jia
 * @date 2018/6/29 上午11:13
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public User getUserByUsername(String username) {
        System.out.println("user service");

        return new User();
    }
}
