package com.renhang.springbootlesson62.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heng.jia
 * @date 2018/7/1 上午11:28
 */
@RestController
public class LogbackController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/logback")
    public String log(@RequestParam String message) {

        String log = "Logback : " + message;

        logger.info(log);

        return log;
    }

}
