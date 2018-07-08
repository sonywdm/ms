package com.renhang.springbootlesson3.service.impl;

import com.renhang.springbootlesson3.dao.SysUserMapper;
import com.renhang.springbootlesson3.domain.User;
import com.renhang.springbootlesson3.mapper.MyBatisUserMapper;
import com.renhang.springbootlesson3.model.SysUser;
import com.renhang.springbootlesson3.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author heng.jia
 * @date 2018/6/30 下午3:47
 */
@Service
public class MyBatisUserServiceImpl implements MyBatisUserService{

    @Autowired
    private MyBatisUserMapper userMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public SysUser selectByPrimaryKey(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }
}
