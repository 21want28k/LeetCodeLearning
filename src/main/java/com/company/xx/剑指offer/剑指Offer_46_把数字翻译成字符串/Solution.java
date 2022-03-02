package com.company.xx.剑指offer.剑指Offer_46_把数字翻译成字符串;

import java.util.Arrays;

public class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - '0';
        }
        System.out.println(Arrays.toString(nums));
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (nums[i - 2] > 0 && 10 * nums[i - 2] + nums[i - 1] <= 25) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int num = 506;
        new Solution().translateNum(num);
    }
}
