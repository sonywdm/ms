package com.renhang.springbootlesson3.service;

import com.renhang.springbootlesson3.domain.JpaUser;

/**
 * @author heng.jia
 * @date 2018/6/30 下午3:29
 */
public interface JpaUserService {

    JpaUser findById(Integer id);
}
