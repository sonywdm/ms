package com.renhang.userapi.fallback;

import com.renhang.userapi.api.UserService;
import com.renhang.userapi.domain.User;

import java.util.Collections;
import java.util.List;

/**
 * @author heng.jia
 * @date 2018/7/3 下午11:44
 */
public class UserServiceFallback implements UserService {

    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return Collections.emptyList();
    }
}
