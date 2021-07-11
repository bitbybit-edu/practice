package com.bitbybit.practice;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class CaffeineTest {

    private static final Logger log = LoggerFactory.getLogger(CaffeineTest.class);

    private Cache<String, Integer> cache = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build();

    private static Map<String, Integer> result;

    static {
        result = new LinkedHashMap<>();
        result.put("1", 1);
        result.put("2", 2);
        result.put("3", 3);
        result.put("4", 4);
        result.put("5", 5);
    }

    @Test
    public void test1() throws InterruptedException {
        Integer integer = cache.get("1", result::get);
        log.info("cacheKey:1={}",integer);
        Assert.isTrue(Objects.equals(integer, 1), "key:1");
        result.put("1", 2);
        Integer integer1 = cache.get("1", result::get);
        log.info("cacheKey:1={}",integer1);
        Assert.isTrue(Objects.equals(integer1, 1), "key:1");
        Assert.isTrue(Objects.equals(result.get("1"), 2), "key:1");

        Integer integer6 = cache.get("6", result::get);
        log.info("cacheKey:6={}",integer6);

        TimeUnit.MINUTES.sleep(2);
        Integer integer2 = cache.get("1", result::get);
        log.info("cacheKey:1={}",integer2);
        Assert.isTrue(Objects.equals(integer2, 2), "key:1");
    }

}
