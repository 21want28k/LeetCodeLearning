package com.company.xx.DP.T198_DP_House_Robber;

public class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0; // 不偷
        dp[0][1] = 0; // 偷
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        return Math.max(dp[n][0], dp[n][1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        new Solution2().rob(nums);
    }
}
