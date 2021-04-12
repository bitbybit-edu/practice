package com.bitbybit.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
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

}


