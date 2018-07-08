package com.renhang.zipkin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;
//import zipkin.server.EnableZipkinServer;

/**
 * @author heng.jia
 * @date 2018/7/6 下午8:38
 */
@SpringBootApplication
@EnableZipkinServer
//@EnableZipkinStreamServer
public class ZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }
}