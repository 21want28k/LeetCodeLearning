package com.company.xx.DP.T343_整数拆分_看的答案;

import java.util.Arrays;

public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int[] nums = {dp[i],dp[i - j] * j,(i-j) *j};
                dp[i] = Arrays.stream(nums).max().getAsInt();
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new Solution().integerBreak(4);
    }
}
