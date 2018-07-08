package com.renhang.springbootlesson7.controller;

import com.renhang.springbootlesson7.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heng.jia
 * @date 2018/7/2 上午11:56
 */
@RestController
@EnableConfigurationProperties(Book.class)
public class BookController {

    @Autowired
    private Book book;

    @GetMapping("/book")
    public Book book() {
        return book;
    }

}
