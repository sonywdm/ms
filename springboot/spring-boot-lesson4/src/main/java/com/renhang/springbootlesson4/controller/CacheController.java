package com.renhang.springbootlesson4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heng.jia
 * @date 2018/6/30 下午4:52
 */
@RestController
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    @Qualifier("simpleCacheManager")
    private CacheManager simpleCacheManager;

    @PostMapping("/save")
    public Map<String, Object> save(@RequestParam String key, @RequestParam String value) {

        Cache cache = simpleCacheManager.getCache("cache-1");

        cache.put(key, value);

        Map<String, Object> result = new HashMap<>();

        result.put(key, value);

        return result;
    }

    @GetMapping("/get/{key}")
    public Map<String, Object> get(@PathVariable String key){
        Cache cache = simpleCacheManager.getCache("cache-1");

        Object value = cache.get(key).get();

        Map<String, Object> result = new HashMap<>();

        result.put(key, value);

        return result;
    }
}
