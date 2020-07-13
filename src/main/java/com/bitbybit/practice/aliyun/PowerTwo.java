package com.bitbybit.practice.aliyun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.ivu4e.com/blog/algorithm/2020-07-10/503.html
 */
public class PowerTwo {

    private static final Logger logger = LoggerFactory.getLogger(PowerTwo.class);

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 1, 31, 7, 15};
        int n = nums.length;
        Map<Integer, Boolean> tags = new HashMap<Integer, Boolean>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) != null) {
                map.get(nums[i]).add(i);
            } else {
                map.put(nums[i], new ArrayList<Integer>());
                map.get(nums[i]).add(i);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int i = 0; i < 30; i++) {
                int ai = entry.getKey();
                int aj = (1 << i) - ai;
                if (map.get(aj) != null) {
                    if (!(map.get(aj).size() == 1 && map.get(aj).get(0) == map.get(ai).get(0))) {
                        map.get(aj).forEach(o -> tags.put(o, true));
                        map.get(ai).forEach(o -> tags.put(o, true));
                    }
                }

            }

        }
        logger.info("{}", n - tags.size());

    }
}
