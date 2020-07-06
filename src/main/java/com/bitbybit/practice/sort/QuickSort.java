package com.bitbybit.practice.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 *
 * @author liulin
 */
public class QuickSort {

    private static final Logger logger = LoggerFactory.getLogger(QuickSort.class);

    public static void main(String[] args) {

        Random random = new Random(47);

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        
        logger.info("初始化数组： array = {}", array);

        quickSortAsc(array, 0, array.length - 1);
        logger.info("升序排序后数组： array = {}", array);

        quickSortDesc(array, 0, array.length - 1);
        logger.info("降序排序后数组： array = {}", array);
    }

    public static int[] quickSortAsc(int[] array, int start, int end) {
        if (end > start) {
            int partition = partitionAsc(array, start, end);
            // 排序基准位置左边
            quickSortAsc(array, start, partition - 1);
            // 排序基准位置右边
            quickSortAsc(array, partition + 1, end);
        }
        return array;
    }

    public static int[] quickSortDesc(int[] array, int start, int end) {
        if (end > start) {
            int partition = partitionDesc(array, start, end);
            // 排序基准位置左边
            quickSortDesc(array, start, partition - 1);
            // 排序基准位置右边
            quickSortDesc(array, partition + 1, end);
        }
        return array;
    }

    /**
     * 设定基准值： a = arr[start]
     * 一次遍历
     * 找到基准应该放的位置 index
     * 将小于a的元素放在index左边 大于a的元素放在index的右边
     *
     * @param arr
     * @param start
     * @param right
     * @return
     */
    private static int partitionAsc(int[] arr, int start, int right) {
        int a = arr[start];
        int index = start + 1;
        for (int i = index; i <= right; i++) {
            if (a > arr[i]) {
                swap(arr, index, i);
                index++;
            }
        }
        swap(arr, index - 1, start);
        return index - 1;
    }

    private static int partitionDesc(int[] arr, int start, int right) {
//        int a = arr[start];
//        int index = 0;
//        for (int i = start + 1; i <= right; i++) {
//            if (a < arr[i]) {
//                swap(arr, index++, i);
//
//            }
//        }
//        swap(arr, index, start);
//        return index;

        int a = arr[start];
        int index = start;
        for (int i = start + 1; i <= right; i++) {
            if (a < arr[i]) {
                index++;
                swap(arr, index, i);
            }
        }
        swap(arr, index, start);
        return index;
    }

    private static void swap(int[] arr, int index, int i) {
        int a = arr[index];
        arr[index] = arr[i];
        arr[i] = a;
    }

}
