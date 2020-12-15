package com.bitbybit.practice;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Java8Test {

    @Test
    public void test1() {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTimeJST = LocalDateTime.now(ZoneId.of("JST", ZoneId.SHORT_IDS));
        System.out.println(localDateTimeJST);
    }

    /**
     * 前30天日期
     */
    @Test
    public void test2() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.minusDays(30);
        String format = localDateTime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss:SSS"));
        System.out.println(format);
    }

}
