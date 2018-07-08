package com.renhang.user.service.provider.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.renhang.user.service.provider.stream.UserMessage;
import com.renhang.userapi.api.UserService;
import com.renhang.userapi.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static com.renhang.user.service.provider.stream.UserMessage.INPUT;


/**
 * @author heng.jia
 * @date 2018/7/5 下午5:02
 */
@Service
public class UserMessageService {

    @Autowired
    private UserMessage userMessage;

    @Autowired
    @Qualifier("inMemoryUserService")
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;


    @ServiceActivator(inputChannel = INPUT)
    public void listen(byte[] data) throws IOException {
        System.out.println("Subscribe by @ServiceActivator");
        saveUser(data);
    }

    @StreamListener(INPUT)
    public void onMessage(byte[] data) throws IOException {
        System.out.println("Subscribe by @StreamListener");
        saveUser(data);
    }

    private void saveUser(String data) throws IOException {
        User user = objectMapper.readValue(data, User.class);
        userService.saveUser(user);
    }

    private void saveUser(byte[] data) {
        // message body 是字节流 byte[]
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            User user = (User) objectInputStream.readObject(); // 反序列化成 User 对象
            userService.saveUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    public void init() {

        SubscribableChannel subscribableChannel = userMessage.input();
        subscribableChannel.subscribe(message -> {
            System.out.println("Subscribe by SubscribableChannel");
            String contentType = message.getHeaders().get("contentType", String.class);
            if ("text/plain".equals(contentType)) {
                try {
                    saveUser((String) message.getPayload());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // message body 是字节流 byte[]
                byte[] body = (byte[]) message.getPayload();
                saveUser(body);
            }
        });
    }

}
