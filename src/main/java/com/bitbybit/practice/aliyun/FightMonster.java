package com.bitbybit.practice.aliyun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * https://developer.aliyun.com/coding/43
 * 现在有3只怪兽，他们的都有自己的血量a,b,c(1<=a,b,c<=100)，当Tom打死第一怪兽的时候花费的代价为0，其余的怪兽的代价为当前的怪兽的血量减去上一个怪兽的血量的绝对值。问Tom打死这些怪兽所需要的最小代价
 * 分别输入三只怪兽的血量
 * 输出打死三只怪兽的最小代价
 *
 * @author liulin
 */
public class FightMonster {
    public static final Logger logger = LogManager.getLogger(FightMonster.class);

    public static void main(String[] args) {
        int solution = solution(98, 56, 9);
        logger.info("result = {}", solution);
    }

    public static int solution(int a, int b, int c) {
        int[] array = new int[]{a, b, c};
        Arrays.sort(array);
        int minum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            minum += Math.abs(array[i + 1] - array[i]);
        }
        return minum;
    }
}
