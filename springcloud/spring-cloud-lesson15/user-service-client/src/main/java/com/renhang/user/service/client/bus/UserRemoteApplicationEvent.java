package com.renhang.user.service.client.bus;

import com.renhang.userapi.domain.User;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * @author heng.jia
 * @date 2018/7/6 下午6:06
 */
public class UserRemoteApplicationEvent extends RemoteApplicationEvent {

    private UserRemoteApplicationEvent() {
    }

    public UserRemoteApplicationEvent(User user, String originService,
                                      String destinationService) {
        super(user, originService, destinationService);
    }

}
