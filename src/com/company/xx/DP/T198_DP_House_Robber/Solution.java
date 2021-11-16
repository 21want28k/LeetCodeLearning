package com.company.xx.DP.T198_DP_House_Robber;


import java.util.Arrays;

public class Solution {
    public static int rob(int[] nums) {
        int n = nums.length;
        // 1~n 存储值，0不算
        int[] dp = new int[n + 1];
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static int rob2(int[] nums) {
        int n = nums.length;
        // 1~n 存储值，0不算
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= n; i++) {
            int current = Math.max(second, first + nums[i - 1]);
            first = second;
            second = current;
        }
        return second;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 1};
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob2(nums));
    }
}