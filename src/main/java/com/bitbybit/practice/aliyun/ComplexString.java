package com.bitbybit.practice.aliyun;

/**
 * https://developer.aliyun.com/coding/39
 */
public class ComplexString {

    public static void main(String[] args) {
        solution("tess", "yes");
    }

    public static int solution(String s1, String s2) {
        System.out.println(solution(s1, s2, 0));
        return 0;
    }

    public static int solution(String s1, String s2, int a) {
        if (s1.length() > s2.length()) {
            s1 = s1.substring(1);
        } else if (s2.length() > s1.length()) {
            s2 = s2.substring(1);
        } else if (s1.length() == s2.length()) {
            if (s1.equals(s2)) {
               return a;
            } else {
                s1 = s1.substring(1);
            }
        }
        int solution = solution(s1, s2, a);
        return ++ solution ;
    }

}
