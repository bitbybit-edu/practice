package com.bitbybit.practice.aliyun;

import java.util.HashMap;
import java.util.Map;

public class MatrixMinimumPathSum {


    private  static int[][] m = new int[4][4];

    static {
        //        4 1 5 3
        //        3 2 7 7
        //        6 5 2 8
        //        8 9 4 5
        m[0][0] = 4; m[0][1] = 1; m[0][2] = 5; m[0][3] = 3;
        m[1][0] = 3; m[1][1] = 2; m[1][2] = 7; m[1][3] = 7;
        m[2][0] = 6; m[2][1] = 5; m[2][2] = 2; m[2][3] = 8;
        m[3][0] = 8; m[3][1] = 9; m[3][2] = 4; m[3][3] = 5;
    }


    private static Map<String, Long> optMap = new HashMap<>();

    public static void main(String[] args) {
        int opt = opt(m);
        System.out.println(opt);
    }

    private static int opt(int[][] m) {
        int[][] opt = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i ++) {
            for (int j = 0; j < m[0].length; j ++){
                if (i == 0 && j != 0) {
                    opt[i][j] = opt[i][j - 1] + m[i][j];
                } else if (i != 0 && j == 0) {
                    opt[i][j] = opt[i - 1][j] + m[i][j];
                } else if (i == 0 && j == 0){
                    opt[i][j] = m[i][j];
                } else {
                    int up = opt[i][j-1] + m[i][j];
                    int left = opt[i-1][j] + m[i][j];
                    opt[i][j] = Math.min(up, left);
                }
            }
        }
        return opt[opt.length - 1][opt[0].length - 1];
    }

    public static int[][] opt(int x, int y) {
        int[][] opt = new int[x + 1][y + 1];
        for (int i = 0; i < x + 1; i ++) {
            for (int j = 0; j < y + 1; j ++){
                if (i == 0 && j != 0) {
                    opt[i][j] = opt[i][j - 1] + m[i][j];
                } else if (i != 0 && j == 0) {
                    opt[i][j] = opt[i - 1][j] + m[i][j];
                } else if (i == 0 && j == 0){
                    opt[i][j] = m[i][j];
                } else {
                    int up = opt[i][j-1] + m[i][j];
                    int left = opt[i-1][j] + m[i][j];
                    opt[i][j] = Math.min(up, left);
                }
            }
        }
        return opt;
    }

    private static int min(int right, int down) {
        return right < down ? right : down;
    }

}
