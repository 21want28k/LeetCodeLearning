package com.company.xx.T518_Coin_Change_2;

import java.util.Arrays;

public class Solution {
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // initialization
        dp[0][0] = 1;
        //row: 0~n  column: 0~amount
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                int coin = coins[i - 1];
                if (j >= coin) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][amount];
    }

    public static int change2(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];


        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        System.out.println(change2(amount, coins));
    }
}
