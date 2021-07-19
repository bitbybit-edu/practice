package com.bitbybit.practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class CommonTest {

    private static final Logger log = LogManager.getLogger(CommonTest.class);

    @Test
    public void test1() {
        long now  = System.currentTimeMillis();
        long seasonStartTime = now- 111 * 60 * 1000;
        log.info(":{}",seasonStartTime);
        if (now > seasonStartTime && now < seasonStartTime + 2 * 60 * 1000) {
            log.info("pre season");
        } else if (now > seasonStartTime + 111 * 60 * 1000 && now < seasonStartTime + 112 * 60 * 1000) {
            log.info("post season");
        }
    }

    @Test
    public void test2() {
        long now  = System.currentTimeMillis();
        long seasonStartTime = now- 110 * 60 * 1000;
        log.info(":{}",seasonStartTime);
    }

    @Test
    public void test3() {
        int hashCode = "sr:match:27743910".hashCode();
        log.info("{}", Math.abs(hashCode % 24) );
    }

    @Test
    public void test5() {
        LocalDateTime now = LocalDateTime.now();
        int dayOfYear = now.getDayOfYear();
        log.info("{}", dayOfYear);
    }

    @Test
    public void md5Test() throws NoSuchAlgorithmException {
        String digest = DigestUtils.md5DigestAsHex("hello world!".getBytes(StandardCharsets.UTF_8));
        log.info("{}", digest);
    }
}
