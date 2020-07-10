package com.bitbybit.practice.aliyun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerTwo {

    private static final Logger logger = LoggerFactory.getLogger(PowerTwo.class);

    public static void main(String[] args) {

        logger.info("a = {}", Integer.MAX_VALUE);
        String s = Integer.toBinaryString(89);
        int i = s.lastIndexOf("1");
        logger.info("i = {}", i);
    }
}
