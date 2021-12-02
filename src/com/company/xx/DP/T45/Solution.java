package com.company.xx.DP.T45;

import java.util.Arrays;

public class Solution {
    public static int jump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j - i <= nums[i]; j++) {
                if (j < n) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        jump(nums);
    }
}
