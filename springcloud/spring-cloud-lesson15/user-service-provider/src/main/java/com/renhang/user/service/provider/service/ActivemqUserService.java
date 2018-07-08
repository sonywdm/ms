package com.renhang.user.service.provider.service;

import com.renhang.user.service.provider.stream.UserMessage;
import com.renhang.userapi.api.UserService;
import com.renhang.userapi.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author heng.jia
 * @date 2018/7/6 上午9:38
 */
@Service
public class ActivemqUserService {

    @Autowired
    @Qualifier("inMemoryUserService")
    private UserService userService;

    @Autowired
    private UserMessage userMessage;

    public void onUserMessage(User user){
        System.out.println("Subscribe by @streamListener");
        userService.saveUser(user);
    }

    @PostConstruct
    public void init() {
        userMessage.activeMQIn().subscribe(message -> {
            if(message instanceof GenericMessage){
                GenericMessage genericMessage = (GenericMessage) message;
                User user = (User) genericMessage.getPayload();
                userService.saveUser(user);
            }
        });
    }

}
