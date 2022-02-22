package com.company.xx.剑指offer.剑指Offer_14_I_剪绳子;

public class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1]; // 1~n
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }

    public int cuttingRope2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        return result * n;
    }
}