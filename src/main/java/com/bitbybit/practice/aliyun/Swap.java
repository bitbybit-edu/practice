package com.bitbybit.practice.aliyun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 不开新空间交换两个数
 * @author liulin
 */
public class Swap {
    private static final Logger logger = LoggerFactory.getLogger(Swap.class);
    public static void main(String[] args) {
        int[] array = new int[]{6, 5};
        array[0] = array[0] ^ array[1];
        logger.info("{}", array);
        array[1] = array[1] ^ array[0];
        logger.info("{}", array);
        array[0] = array[0] ^ array[1];
        logger.info("{}", array);

    }
}
