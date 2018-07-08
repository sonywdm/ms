package com.renhang.user.service.client.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renhang.user.service.client.stream.UserMessage;
import com.renhang.userapi.api.UserService;
import com.renhang.userapi.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author heng.jia
 * @date 2018/7/4 上午12:12
 * 注意：官方建议 客户端和服务端不要同时实现 Feign 接口
 * 这里的代码只是一个说明，实际情况最好使用组合的方式，而不是继承
 */
@RestController
public class UserServiceClientController implements UserService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMessage userMessage;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JmsTemplate jmsTemplate;

//    private final KafkaTemplate<String, Object> kafkaTemplate;
//
//    @Autowired
//    public UserServiceClientController(KafkaTemplate kafkaTemplate){
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    @PostMapping("/kafka/user/save/message")
//    public Boolean saveUserByMessage(@RequestBody User user){
//        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("daocloud-users", 0, user);
//        return future.isDone();
//    }

    @PostMapping("/rabbit/user/save/message")
    public boolean saveUserByRabbitMessage(@RequestBody User user) throws JsonProcessingException {
        MessageChannel messageChannel = userMessage.output();
        // User 序列化成 JSON
        String payload = objectMapper.writeValueAsString(user);
        GenericMessage<String> message = new GenericMessage<String>(payload);
        // 发送消息
        return messageChannel.send(message);
    }

    @PostMapping("/activemq/user/save/message")
    public boolean saveUserByActiveMQMessage(@RequestBody User user) throws Exception {
        jmsTemplate.convertAndSend(user);
        return true;
    }

    @PostMapping("/activemq/stream/user/save/message")
    public boolean saveUserByActiveMQStream(@RequestBody User user) throws Exception {
        MessageChannel messageChannel = userMessage.activeMQOut();
        GenericMessage message = new GenericMessage(user);
        return messageChannel.send(message);
    }

    // 通过方法继承，URL 映射 ："/user/save"
    @Override
    public boolean saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // 通过方法继承，URL 映射 ："/user/find/all"
    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

}
