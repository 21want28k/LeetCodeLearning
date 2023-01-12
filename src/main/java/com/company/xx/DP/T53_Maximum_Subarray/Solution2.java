package com.company.xx.DP.T53_Maximum_Subarray;

import java.util.Arrays;

public class Solution2 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    public static void main(String[] args) {
        new Solution2().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
