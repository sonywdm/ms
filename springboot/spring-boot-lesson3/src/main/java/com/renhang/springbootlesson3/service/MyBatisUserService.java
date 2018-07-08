package com.renhang.springbootlesson3.service;

import com.renhang.springbootlesson3.domain.User;
import com.renhang.springbootlesson3.model.SysUser;

/**
 * @author heng.jia
 * @date 2018/6/30 下午3:47
 */
public interface MyBatisUserService {

    User findUserById(Integer id);

    SysUser selectByPrimaryKey(Integer id);

}
