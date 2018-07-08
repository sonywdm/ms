package com.renhang.user.service.client.web.controller;

import com.renhang.user.service.client.bus.UserRemoteApplicationEvent;
import com.renhang.userapi.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heng.jia
 * @date 2018/7/6 下午7:51
 */
@RestController
public class BusEventController implements ApplicationContextAware, ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;

    private ApplicationContext applicationContext;


    @PostMapping("/bus/event/publish/user")
    public boolean publishUserEvent(@RequestBody User user,
                                    @RequestParam(value = "destination", required = false) String destination) {

        String serviceInstanceId = applicationContext.getId();
        UserRemoteApplicationEvent event = new UserRemoteApplicationEvent(user, serviceInstanceId, destination);
        eventPublisher.publishEvent(event);
        return true;

    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
