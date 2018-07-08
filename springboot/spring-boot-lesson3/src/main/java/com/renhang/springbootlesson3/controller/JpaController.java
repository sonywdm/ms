package com.renhang.springbootlesson3.controller;

import com.renhang.springbootlesson3.domain.JpaUser;
import com.renhang.springbootlesson3.service.JpaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heng.jia
 * @date 2018/6/30 下午3:27
 */
@RestController
public class JpaController {

    @Autowired
    private JpaUserService jpaUserService;

    @GetMapping("/jpa/user/{id}")
    public JpaUser findById(@PathVariable Integer id){
        return jpaUserService.findById(id);
    }

}
