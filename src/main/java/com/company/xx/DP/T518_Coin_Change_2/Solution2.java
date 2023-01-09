package com.company.xx.DP.T518_Coin_Change_2;

import java.util.Arrays;

public class Solution2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    public static void main(String[] args) {
        new Solution2().change(5, new int[]{1, 2, 5});
    }
}
