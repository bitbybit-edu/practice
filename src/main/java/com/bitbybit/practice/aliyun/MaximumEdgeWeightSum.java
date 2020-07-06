package com.bitbybit.practice.aliyun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * https://developer.aliyun.com/coding/44
 * 现在有n个点(1<=n<=1000)，每个点都有一个值称为点权ai(ai为偶数，1<=ai<=1000)，现在可以将任意两个点相连，连起来以后这条边也有一个值称为边权，这个边的边权为这两个点的点权之和的一半。现在需要你添加n-1条边，问将这n个点连通以后(连通是指任意两个点都能互相到达)的最大的边权和是多少。
 * 输入点的数量n；和n个数，表示点权的值
 * 输出最大的边权和
 *
 * @author liulin
 */
public class MaximumEdgeWeightSum {

    private static final Logger logger = LoggerFactory.getLogger(MaximumEdgeWeightSum.class);

    public static void main(String[] args) {
        int[] nums = new int[]{388, 416, 902, 992, 216, 316, 142, 356, 864, 706, 328, 136, 320, 564, 82, 950, 700, 238, 106, 58};
        int solution = solution(nums.length, nums);
        logger.info("result = {}", solution);
    }

    public static int solution(int n, int[] nums) {
        Arrays.sort(nums);
        int maximum = 0;
        for (int i = n - 2; i >= 0; i--) {
            maximum += (nums[n - 1] + nums[i]) / 2;
        }
        return maximum;
    }
}
