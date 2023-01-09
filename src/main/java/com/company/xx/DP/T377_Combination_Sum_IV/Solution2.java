package com.company.xx.DP.T377_Combination_Sum_IV;

import java.util.Arrays;

public class Solution2 {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < n; i++) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[target];
    }

    public int method2(int[] weights, int bagWeight) {
        int n = weights.length;

        int[][] dp = new int[n + 1][bagWeight + 1];
        for (int i = 0; i <= bagWeight; i++) {
            dp[1][i] = 1;
        }
        for (int j = 0; j <= bagWeight; j++) {
            for (int i = 2; i <= n; i++) {
                if (j >= weights[i - 1]) {
                    dp[i][j] += dp[i][j - weights[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][bagWeight];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution2().combinationSum4(nums, 4);
        new Solution2().method2(nums, 4);
    }
}
