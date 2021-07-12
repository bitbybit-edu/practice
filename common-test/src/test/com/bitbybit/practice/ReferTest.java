package com.bitbybit.practice;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class ReferTest {

    private String ac;

    @Test
    public void test1() {
        BigDecimal[] homeMulti = new BigDecimal[5];
        Arrays.fill(homeMulti, BigDecimal.ZERO);
        for (BigDecimal a : homeMulti) {
            System.out.println(a);
        }

    }

    @Test
    public void test2() {
        /**
         * custombet替换原有market
         */
        Map<String, String> CUSTOM_BET_MARKETS_REPLACE_MAP = Map.ofEntries(
                Map.entry("854-total=2.5", "3000009-"),
                Map.entry("855-total=2.5", "3000010-"),
                Map.entry("856-total=2.5", "3000011-"),
                Map.entry("857-total=2.5", "3000012-"),
                Map.entry("858-total=2.5", "3000013-"),
                Map.entry("859-total=2.5", "3000014-"),
                Map.entry("860-", "3000015-"),
                Map.entry("861-", "3000016-"),
                Map.entry("862-", "3000017-"),
                Map.entry("863-", "3000018-"),
                Map.entry("864-", "3000019-"),
                Map.entry("865-", "3000020-")
        );
        Map<String, String> CUSTOM_BET_MARKETS_REPLACE_MAP_REVERSE = CUSTOM_BET_MARKETS_REPLACE_MAP.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        String replacedMarketId = CUSTOM_BET_MARKETS_REPLACE_MAP_REVERSE.get(3000020 + "-");
        String[] split = replacedMarketId.split("-");

    }

    @Test
    public void test3() {
        BigDecimal bigDecimal = BigDecimal.valueOf(0.9).setScale(2, RoundingMode.HALF_UP);
        System.out.println(bigDecimal.toPlainString());
    }

    @Test
    public void test4() {
        List.of(1, 2, 3).forEach(integer -> {
            if (integer == 2) {
                System.out.println("find 2");
                return;
            }
            System.out.println(integer);
        });
    }


    @Test
    public void test5() {
        System.out.println(BigDecimal.valueOf(100000L).divide(BigDecimal.valueOf(0.33F), 16, RoundingMode.HALF_UP).longValue());
    }

    @Test
    public void test6() {
        System.out.println(BigDecimal.valueOf(1.0000D).compareTo(BigDecimal.ONE) == 0);
    }

    @Test
    public void test7() {
        String a = "sr:match:25061974/uof:1/sr:sport:1/1";
        String replace = a.replace("uof:1", "uof:3");
        System.out.println(replace);
    }

    @Test
    public void test8() {
        String a = "-a";
        String[] split = a.split("-");
        System.out.println(split);
    }

    @Test
    public void test9() {
        LocalDate localDate = LocalDate.of(2020, 11, 30);
        LocalDate localDateNow = LocalDate.now();
        long until = localDate.until(localDateNow, ChronoUnit.DAYS);
        System.out.println(until);

        long l = until / 7;
        long l1 = until % 7;
        System.out.println(l + ":" + l1);
    }

    @Test
    public void test10() {
        double v = Math.log(0.5D) / Math.log(0.9D);
        double v2 = Math.log(2D) / Math.log(1.1D);
        System.out.println(v + ":" + v2);
    }

    @Test
    public void test11() {

        Map<String, String> aa = new HashMap<String, String>();
        ReferTest referTest = new ReferTest();
        referTest.setAc(aa.get(null));
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    @Test
    public void test12() {

        Platform ussd = Platform.valueOf("app");
    }

    @Test
    public void test13() {
        int times = 3;
        float base = 1, grow  = 10;
        float v = timesValue(base, times, grow);
        System.out.println(v);
    }

    private float timesValue(float base, int times, float grow) {
        float v;
        if (times == 0) {
            return v = base;
        } else {
             v = base + base * grow / 100;
        }

        return timesValue(v, times - 1,  grow);
    }

}

enum Platform {
    app,
    wap,
    web,
    android;
}


