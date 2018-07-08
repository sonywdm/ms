package com.renhang.springbootlesson2.service;

import com.renhang.springbootlesson2.dto.User;

/**
 * @author heng.jia
 * @date 2018/6/29 上午11:12
 */
public interface UserService {

    User getUserByUsername(String username);

}
