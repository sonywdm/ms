package com.renhang.web.controller;

import com.renhang.domain.User;
import com.renhang.hystrix.UserRibbonClientHystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collection;

/**
 * @author heng.jia
 * @date 2018/7/3 下午3:04
 */
@RestController
public class UserRibbonController {

    /**
     * 负载均衡器客户端
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${provider.service.name}")
    private String providerServiceName;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("")
    public String index() throws IOException {

        User user = new User();
        user.setId(1L);
        user.setName("daocloud");

        // 选择指定的 service Id
        ServiceInstance serviceInstance = loadBalancerClient.choose(providerServiceName);

        return loadBalancerClient.execute(providerServiceName, serviceInstance, instance -> {

            //服务器实例，获取 主机名（IP） 和 端口
            String host = instance.getHost();
            int port = instance.getPort();
            String url = "http://" + host + ":" + port + "/user/save";
            RestTemplate restTemplate = new RestTemplate();

            return restTemplate.postForObject(url, user, String.class);

        });

    }

    /**
     * 调用 user-service-provider "/user/list" REST 接口，并且直接返回内容
     * 增加 短路功能
     */
    @GetMapping("/user-service-provider/user/list")
    public Collection<User> getUsersList() {
        return new UserRibbonClientHystrixCommand(providerServiceName, restTemplate).execute();
    }

}
