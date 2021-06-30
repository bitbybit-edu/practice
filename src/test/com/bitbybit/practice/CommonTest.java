package com.bitbybit.practice;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonTest {

    private static final Logger log = LoggerFactory.getLogger(CommonTest.class);

    @Test
    public void test1() {
        long now  = System.currentTimeMillis();
        long seasonStartTime = now- 111 * 60 * 1000;
        log.info(":{}",seasonStartTime);
        if (now > seasonStartTime && now < seasonStartTime + 2 * 60 * 1000) {
            log.info("pre season");
        } else if (now > seasonStartTime + 111 * 60 * 1000 && now < seasonStartTime + 112 * 60 * 1000) {
            log.info("post season");
        } else {

        }
    }

    @Test
    public void test2() {
        long now  = System.currentTimeMillis();
        long seasonStartTime = now- 110 * 60 * 1000;
        log.info(":{}",seasonStartTime);
    }
}
