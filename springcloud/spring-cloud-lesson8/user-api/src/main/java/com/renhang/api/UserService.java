package com.renhang.api;

import com.renhang.domain.User;

import java.util.List;

/**
 * @author heng.jia
 * @date 2018/7/3 上午11:31
 */
public interface UserService {

    Boolean saveUser(User user);

    List<User> findAll();

}
