package com.renhang.user.service.provider.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author heng.jia
 * @date 2018/7/5 下午3:00
 */
public interface UserMessage {

    String INPUT = "user-message";

    @Input(INPUT)
    // 管道名称
    SubscribableChannel input();

    @Input("activemq-in")
    SubscribableChannel activeMQIn();

}
