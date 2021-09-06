package com.company.xx.T1_两数之和;

import java.util.Arrays;
import java.util.HashMap;

public class Demo {
    public static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ints[0] = i;
                    ints[1] = j;
                    return ints;
                }
            }
        }
        return null;
    }

    /*
        1. 主要的是想到空间换时间，用hash表
        2. 只遍历一轮，一边遍历一边插入数据，代替全部插入数据，
           然后左数字+右数字的传统思想，而是有了一定量的数据，
           以右+左边的数字得到结果
     */
    public static int[] method2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3, 3};
        System.out.println(Arrays.toString(method2(ints, 6)));
    }
}
