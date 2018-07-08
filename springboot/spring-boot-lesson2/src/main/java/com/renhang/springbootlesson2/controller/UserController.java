package com.renhang.springbootlesson2.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.renhang.springbootlesson2.dto.User;
import com.renhang.springbootlesson2.dto.UserQueryCondition;
import com.renhang.springbootlesson2.exception.UserNotExistException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author heng.jia
 * @date 2018/6/28 下午8:07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public User create(@Valid @RequestBody User user){

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");

        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@RequestBody User user){
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");

        return user;
    }

    @GetMapping
    @JsonView(User.userSimpleView.class)
    @ApiOperation(value = "用户查询服务")
    public List<User> query(@Valid UserQueryCondition condition, BindingResult errors){

        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        List<User> users = new ArrayList<>();
        User user = new User();
        user.setPassword("123");
        users.add(user);

        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam("用户id") @PathVariable String id){
        throw new UserNotExistException(id);
//        User user = new User();
//        user.setUsername("daocloud");
//        return user;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        System.out.println("daocloud");
    }
}
