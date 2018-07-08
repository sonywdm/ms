package com.renhang.user.service.client.ping;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @author heng.jia
 * @date 2018/7/4 上午12:06
 */
public class MyPing implements IPing {

    @Override
    public boolean isAlive(Server server) {

        String host = server.getHost();
        int port = server.getPort();
        // /health endpoint
        // 通过 Spring 组件来实现URL 拼装
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        builder.scheme("http");
        builder.host(host);
        builder.port(port);
        builder.path("/health");
        URI uri = builder.build().toUri();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity responseEntity = restTemplate.getForEntity(uri, String.class);
        // 当响应状态等于 200 时，返回 true ，否则 false
        return HttpStatus.OK.equals(responseEntity.getStatusCode());
    }

}
