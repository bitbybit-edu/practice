package com.bitbybit.practice;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

public class PTest {
    static LinkedHashMap<String, Double> bifen = new LinkedHashMap<String, Double>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        possionTest();
    }

    private static void possionTest() {
        double hky = 2.363636364;//主队主场进球期望值
        double aky = 0.516129032;//客队客场进球期望值
        int k = 11;//个数 0 -- 10  7个
        LinkedList<Double> hky_expiList = new LinkedList<Double>();
        LinkedList<Double> aky_expiList = new LinkedList<Double>();
        for (int i = 0; i <= k; i++) {
            hky_expiList.add(getPossion(i, hky));
            aky_expiList.add(getPossion(i, aky));
        }

        System.out.println("hky_expiList:" + hky_expiList);
        System.out.println("aky_expiList:" + aky_expiList);

        double zds = getZds(hky_expiList, aky_expiList);//主队胜概率;
        DecimalFormat df = new DecimalFormat("#.0000");
        zds = Double.parseDouble(df.format(zds));
        System.out.println("zds:" + zds);

        double zdp = getZdp(hky_expiList, aky_expiList);//主队平概率;
        zdp = Double.parseDouble(df.format(zdp));
        System.out.println("zdp:" + zdp);

        double zdf = getZdf(hky_expiList, aky_expiList);//主队负概率;
        zdf = Double.parseDouble(df.format(zdf));
        System.out.println("zdf:" + zdf);

        System.out.println(bifen.toString());
        Set<String> set = bifen.keySet();
        Iterator ite = set.iterator();
        for (; ite.hasNext(); ) {
            String tmp = (String) ite.next();
            System.out.println(tmp + "  " + bifen.get(tmp));
        }

    }

    private static double getZdf(LinkedList<Double> hky_expiList,
                                 LinkedList<Double> aky_expiList) {
        double result = 0;
        for (int i = 1; i < hky_expiList.size(); i++) {
            for (int j = 0; j < i; j++) {
                double tmp = aky_expiList.get(i) * hky_expiList.get(j);
                DecimalFormat df = new DecimalFormat("#.0000");
                tmp = Double.parseDouble(df.format(tmp));
                result += tmp;
                bifen.put(i + ":" + j, tmp);
            }
        }
        return result;
    }

    private static double getZdp(LinkedList<Double> hky_expiList,
                                 LinkedList<Double> aky_expiList) {
        double result = 0;
        for (int i = 0; i < hky_expiList.size(); i++) {
            result += hky_expiList.get(i) * aky_expiList.get(i);
        }

        return result;
    }

    private static double getZds(LinkedList<Double> hky_expiList,
                                 LinkedList<Double> aky_expiList) {
        double result = 0;
        for (int i = 1; i < hky_expiList.size(); i++) {
            for (int j = 0; j < i; j++) {
                result += hky_expiList.get(i) * aky_expiList.get(j);
            }

        }


        return result;
    }

    //k,进球数 ,y 期望值
    private static double getPossion(int k, double y) {

        double result = 0;
        if (k == 0) {
            result = Math.exp(-y);
        } else {
            result = Math.pow(y, k) / getFactorial(k) * Math.exp(-y);
        }
        DecimalFormat df = new DecimalFormat("#.0000");
        result = Double.parseDouble(df.format(result));
        return result;
    }

    private static int getFactorial(int k) {
        int result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * i;
        }
        return result;
    }

}
