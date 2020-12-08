package com.bitbybit.practice;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Java8Test {

    @Test
    public void test1() {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTimeJST = LocalDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS));
        System.out.println(localDateTimeJST);
    }
}
