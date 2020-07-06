package com.bitbybit.practice.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        quickSort(array, 0, array.length - 1);
        logger.info("排序后数组： array = {}", array);
    }

    public static int[] quickSort(int[] array, int start, int end) {
        if (end > start) {
            int partition = partition(array, start, end);
            // 排序基准位置左边
            quickSort(array, start, partition - 1);
            // 排序基准位置右边
            quickSort(array, partition + 1, end);
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
    private static int partition(int[] arr, int start, int right) {
        int a = arr[start];
        int index = start + 1;
        for (int i = index; i <= right; i++) {
            if (a >= arr[i]) {
                swap(arr, index, i);
                index++;
            }
        }
        swap(arr, index - 1, start);
        return index - 1;
    }

    private static void swap(int[] arr, int index, int i) {
        int a = arr[index];
        arr[index] = arr[i];
        arr[i] = a;
    }

}
