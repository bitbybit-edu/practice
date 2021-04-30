package com.bitbybit.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReferTest {

    @Test
    public void test1() {
        BigDecimal[] homeMulti = new BigDecimal[5];;
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
                Map.entry( "854-total=2.5", "3000009-"),
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
    public  void test3() {
        BigDecimal bigDecimal = BigDecimal.valueOf(0.9).setScale(2, RoundingMode.HALF_UP);
        System.out.println(bigDecimal.toPlainString());
    }

    @Test
    public  void test4() {
        List.of(1,2,3).forEach(integer -> {
            if (integer == 2) {
                System.out.println("find 2");
                return;
            }
            System.out.println(integer);
        });
    }



    @Test
    public  void test5() {
        System.out.println(BigDecimal.valueOf(100000L).divide(BigDecimal.valueOf(0.33F), 16, RoundingMode.HALF_UP).longValue());
    }

    @Test
    public  void test6() {
        System.out.println(BigDecimal.valueOf(1.0000D).compareTo(BigDecimal.ONE) == 0);
    }

    @Test
    public  void test7() {
        String a = "sr:match:25061974/uof:1/sr:sport:1/1";
        String replace = a.replace("uof:1", "uof:3");
        System.out.println(replace);
    }

    @Test
    public  void test8() {
        String a = "-a";
        String[] split = a.split("-");
        System.out.println(split);
    }

    @Test
    public  void test9() {
        LocalDate localDate = LocalDate.of(2020, 11, 14);
        LocalDate localDateNow = LocalDate.now();
        long until = localDate.until(localDateNow, ChronoUnit.DAYS);
        System.out.println(until);

        long l = until / 7;
        long l1 = until % 7;
        System.out.println(l + ":" +l1);
    }


}


