package com.renhang.springbootlesson3.service.impl;

import com.renhang.springbootlesson3.domain.JpaUser;
import com.renhang.springbootlesson3.repository.JpaUserRepository;
import com.renhang.springbootlesson3.service.JpaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author heng.jia
 * @date 2018/6/30 下午3:30
 */
@Service
public class JpaUserServiceImpl implements JpaUserService {

    @Autowired
    private JpaUserRepository repository;

    @Override
    public JpaUser findById(Integer id) {
        return repository.findById(id);
    }
}
