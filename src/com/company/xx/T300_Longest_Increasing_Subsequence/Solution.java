package com.company.xx.T300_Longest_Increasing_Subsequence;

import java.util.Arrays;

public class Solution {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1]; // dp[i]代表前i个（包括i且i必须选）数字的最长子序列
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 0, 3, 2, 3};
        int[] nums = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
//        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
