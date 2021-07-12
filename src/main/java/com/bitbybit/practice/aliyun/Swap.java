package com.bitbybit.practice.aliyun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 不开新空间交换两个数
 * @author liulin
 */
public class Swap {
    private static final Logger logger = LogManager.getLogger(Swap.class);
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
