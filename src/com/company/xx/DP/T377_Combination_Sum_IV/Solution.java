package com.company.xx.DP.T377_Combination_Sum_IV;


import java.util.Arrays;

public class Solution {
    public static int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];

        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < n; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[target];
    }

    public static int combinationSum42(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        System.out.println(combinationSum42(nums, target));
    }
}