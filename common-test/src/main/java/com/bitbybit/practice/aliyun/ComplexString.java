package com.bitbybit.practice.aliyun;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 题目： https://developer.aliyun.com/coding/39
 * 解析： https://developer.aliyun.com/article/751343
 * <p>
 * 现在有两个字符串s1和s2（长度不超过200000），Tom是一个有强迫症的人，他想要把这两个字符串变的相同。
 * <p>
 * <p>
 * 但是每次只能删除其中一个字符串的最左端的字符，问最少需要经过多少次操作才能使这两个字符串变的相同？
 * <p>
 * 输入内容为两个，第一个为字符串s1，第二个为字符串s2
 *
 * @author liulin
 */
public class ComplexString {
    private static final Logger logger = LogManager.getLogger(ComplexString.class);

    public static void main(String[] args) {
//        solution("tess", "yes");
        solution2("1111es", "yes");
    }

    public static int solution(String s1, String s2) {
        System.out.println(solution(s1, s2, 0));
        return 0;
    }

    public static int solution2(String s1, String s2) {
        /* 找到较短的字符串作为循环次数 */
        int length1 = s1.length();
        int length2 = s2.length();
        int forCount = Math.min(length1, length2) - 1;
        int i = 0;
        for (; forCount >= 0; forCount--) {
            if (s1.charAt((length1 - 1) - i) != s2.charAt((length2 - 1) - i)) {
                break;
            }
            i++;
        }
        i = length1 + length2 - 2 * i;
        logger.info("count = {}", i);
        return i;
    }

    /**
     * 这种方法可以解题　　　但是会 head memory 溢出
     *
     * @param s1
     * @param s2
     * @param a
     * @return
     */
    public static int solution(String s1, String s2, int a) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 > length2) {
            s1 = s1.substring(1);
        } else if (length2 > length1) {
            s2 = s2.substring(1);
        } else if (length1 == length2) {
            if (s1.equals(s2)) {
                return a;
            } else {
                s1 = s1.substring(1);
            }
        }
        int solution = solution(s1, s2, a);
        return ++solution;
    }

}
