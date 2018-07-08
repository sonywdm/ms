package com.renhang.springbootlesson4.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author heng.jia
 * @date 2018/6/30 下午4:51
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public CacheManager simpleCacheManager() {

        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        ConcurrentMapCache cache = new ConcurrentMapCache("cache-1");
        ConcurrentMapCache personsCache = new ConcurrentMapCache("persons");

        simpleCacheManager.setCaches(Arrays.asList(cache, personsCache));

        return simpleCacheManager;

    }
}
