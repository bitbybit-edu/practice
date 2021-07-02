package com.bitbybit.practice;

import com.bitbybit.practice.spi.Sound;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ServiceLoader;

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
        int hashCode = "sr:match:27957882".hashCode();
        log.info("{}", Math.abs(hashCode) % 24);
    }

    @Test
    public void test4() {
        ServiceLoader<Sound> loads = ServiceLoader.load(Sound.class);
        loads.forEach(load -> System.out.println(load.sound()));
    }
}
