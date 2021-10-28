package com.company.xx.T213_DP_House_Robber2;

import java.util.Arrays;

public class Solution {

    public static int rob(int[] nums) {
        // 数字范围是0~n-1
        int n = nums.length;
        // 1~n 存储值，0不算
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //
        return Math.max(rob2(nums, 0, n - 2), rob2(nums, 1, n - 1));
    }

    /**
     * 是包含start和end两个数字的
     */
    public static int rob2(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int current = Math.max(second, first + nums[i]);
            first = second;
            second = current;
        }
        return second;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 3, 2};
//        int[] nums = new int[]{1, 2, 3, 1};
        int[] nums = new int[]{1, 2, 3};
        System.out.println(rob(nums));
    }
}
