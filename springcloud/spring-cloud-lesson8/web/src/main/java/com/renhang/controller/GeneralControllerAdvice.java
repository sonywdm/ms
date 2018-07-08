package com.renhang.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author heng.jia
 * @date 2018/7/3 下午5:47
 */
@ControllerAdvice
public class GeneralControllerAdvice {

    /**
     * 处理 404
     *
     * @param throwable
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public String handle404(Throwable throwable) {
        return "Page was not found!";
    }
}
