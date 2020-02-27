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

    /**
     * 这种方法可以解题　　　但是会 head memory 溢出
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
        return ++ solution ;
    }

}
