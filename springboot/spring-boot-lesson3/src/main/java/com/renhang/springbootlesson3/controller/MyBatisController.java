package com.renhang.springbootlesson3.controller;

import com.renhang.springbootlesson3.domain.User;
import com.renhang.springbootlesson3.model.SysUser;
import com.renhang.springbootlesson3.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heng.jia
 * @date 2018/6/30 下午3:47
 */
@RestController
public class MyBatisController {

    @Autowired
    private MyBatisUserService userService;

    @GetMapping("/mybatis/user/{id}")
    public User findUserById(@PathVariable Integer id){
        return userService.findUserById(id);
    }

    @GetMapping("/generetor/user/{id}")
    public SysUser findSysUserById(@PathVariable Integer id){
        return userService.selectByPrimaryKey(id);
    }

}
