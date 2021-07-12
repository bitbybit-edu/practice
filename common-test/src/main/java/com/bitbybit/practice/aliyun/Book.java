package com.bitbybit.practice.aliyun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * https://developer.aliyun.com/coding/41
 * 在书架上摆着一些书，这些书只有两种颜色，要么是黄色，要么是蓝色，突然某一天这些书被施了魔法，如果一本黄色和一本蓝色的书挨着，
 * 这两本书就会消失不见，然后右边的书会往左边移动，直到和左边的书挨着，如果这两本颜色不同，这两本书又会神秘消失。
 * 现在给你一个只包含A和B的字符串s(1<=|s|<=100000)，其中A表示黄色的书，B表示蓝色的书，问这n本书中最多会消失多少本书。
 * 输入一个字符串s，s中A表示黄色的书，B表示蓝色的书
 * 输出最多会消失多少本书
 *
 * @author liulin
 */
public class Book {

    public static final Logger logger = LogManager.getLogger(Book.class);

    public static void main(String[] args) {
        solution("ABABAABABBABABABABBABABBAABBABABB");
    }

    public static int solution(String str) {
        char[] chars = str.toCharArray();
        int aNum = 0;
        int bNum = 0;
        for (char c : chars) {
            if (c == 'A') {
                aNum++;
            } else {
                bNum++;
            }
        }
        logger.info("result = {}", Math.min(aNum, bNum) * 2);
        return Math.min(aNum, bNum) * 2;
    }
}
