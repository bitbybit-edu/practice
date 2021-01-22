package com.bitbybit.practice;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Java8Tests {

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
        LocalDateTime localDateTime1 = localDateTime.minusMonths(6L);

        String format = localDateTime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
        System.out.println(format);
    }

    /**
     * 前30天日期
     */
    @Test
    public void test3() {
        LocalDateTime localDateTime = LocalDateTime.now();
        for (int i = 1; i <= 3; i++) {
            LocalDateTime localDateTime1 = localDateTime.minusDays(30 * i);
            String format = localDateTime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
            System.out.println(format);
        }

    }

    @Test
    public void test4() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime last = today.minusDays(30);
        LocalDateTime middle = last.minusDays(30);
        LocalDateTime head = middle.minusDays(30);
        String format1 = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
        String format2 = last.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
        String format3 = middle.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
        String format4 = head.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));
        System.out.println(format1);
        System.out.println(format2);
        System.out.println(format3);
        System.out.println(format4);
    }


}
