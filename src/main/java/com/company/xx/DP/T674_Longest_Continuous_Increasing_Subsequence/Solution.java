package com.company.xx.DP.T674_Longest_Continuous_Increasing_Subsequence;

public class Solution {
    public static int findLengthOfLCIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n + 1]; // 1~n dp[i] 前i个数字的最长连续子序列长度，第i个数字包括在内
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            int curNum = nums[i - 1];
            int preNum = nums[i - 2];
            if (curNum > preNum) {
                dp[i] = dp[i - 1] + 1;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static int findLengthOfLCIS2(int[] nums) {
        int n = nums.length;

        int pre = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            int cur = 1;
            int curNum = nums[i - 1];
            int preNum = nums[i - 2];
            if (curNum > preNum) {
                cur = pre + 1;
            }
            pre = cur;
            max = Math.max(cur, max);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, 5, 4, 7};
//        int[] nums = new int[]{2, 2, 2, 2, 2};
        int[] nums = new int[]{1, 3, 5, 4, 7};
        System.out.println(findLengthOfLCIS2(nums));
    }
}