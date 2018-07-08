package com.renhang.springbootlesson2.validator;

import com.renhang.springbootlesson2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author heng.jia
 * @date 2018/6/29 上午11:07
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        userService.getUserByUsername("daocloud");
        System.out.println("valid");
        return true;
    }
}
