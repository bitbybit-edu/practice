package com.bitbybit.practice.aliyun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Tom发现了一种神奇的字符串-斐波那契字符串,定义f[1]=0,f[2]=1,对于所有的i>2都有
 * f[i]=f[i-2]+f[i-1]，其中“+”代表拼接，比如01+10=0110，现在对于字符串f[n]，请判断
 * f[n]的第k项是0，还是1。
 * 输入两个数字n
 * 和k(n<=300,k<=1000000000)。
 * 输出f[n]的第k位，如果k大于f[n]的位数，则输出-1。
 */
public class FibonacciString {

    private static final Logger logger = LogManager.getLogger(FibonacciString.class);

    public static void main(String[] args) {
        solution(25, 1);

    }

    public static int solution(int n, int k) {
        String fibonacci = fibonacci(n);
        logger.info("{}",fibonacci);
        return 0;
    }

    private static String fibonacci(int n) {
        String result;
        if (n == 1) {
            result = "0";
        } else if (n == 2) {
            result = "1";
        } else {
            result = fibonacci(n - 2) + fibonacci(n - 1);
        }
        return result;
    }
}
