package com.bitbybit.practice.aliyun;


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSearch {

    List<Integer> elements = new ArrayList<>();

    public static void main(String[] args) {
        int solution = solution(6, new int[]{1, 2, 3, 3, 2, 1});
        System.out.println(solution);
    }

    public static int solution(int n, int[] a) {
        float[][] avg = new float[n][n];
        float maxAvg = 0;
        int maxJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (j == 0) {
                    avg[i][j] = a[i];

                } else {
                    avg[i][j] = (j * avg[i][j -1] + a[i + j]) / (j + 1) ;
                }

                if (avg[i][j] > maxAvg) {
                    maxAvg = avg[i][j];
                    maxJ = j;
                }

                if (avg[i][j] == maxAvg && j > maxJ) {
                    maxJ = j;
                }

            }
        }

        return maxJ + 1;
    }
}
