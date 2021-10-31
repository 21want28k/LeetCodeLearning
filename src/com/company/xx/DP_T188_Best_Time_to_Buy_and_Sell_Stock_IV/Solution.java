package com.company.xx.DP_T188_Best_Time_to_Buy_and_Sell_Stock_IV;

import java.util.Arrays;

public class Solution {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        // dp[i][j]代表第i天，
        // j代表第i天第状态，共五种。
        // - 0：当天无交易
        // - 1：第一次买入
        // - 2：第一次卖出
        // - 3：第二次买入
        // - 4：第二次卖出
        // - ....
        int[][] dp = new int[n + 1][2 * k + 1];


        // initialization
        for (int i = 0; i < dp[0].length; i++) {
            if (i % 2 == 1) {
                dp[1][i] = -prices[0];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        for (int i = 2; i < n + 1; i++) {
            int price = prices[i - 1];
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j <= 2 * k; j++) {
                // j is odd
                if (j % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - price);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + price);
                }
            }
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - price);
//            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + price);
//            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - price);
//            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + price);
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][2 * k];
    }

    /**
     * 失败的，做不出来。
     */
    public static int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        // dp[i][j]代表第i天，
        // j代表第i天第状态，共五种。
        // - 0：当天无交易
        // - 1：第一次买入
        // - 2：第一次卖出
        // - 3：第二次买入
        // - 4：第二次卖出
        // - ....
        int nothing = 0;
        // 1~k
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            int price = prices[0];
            buy[i] = -price;
            sell[i] = 0;
        }
        for (int i = 2; i < n + 1; i++) {
            int price = prices[i - 1];
            for (int j = 1; j <= k; j++) {
                if (j == 1) {
                    buy[j] = Math.max(buy[j - 1], nothing - price);
                } else {
                    buy[j] = Math.max(buy[j - 1], sell[j - 1] - price);
                }
                sell[j] = Math.max(sell[j - 1], buy[j - 1] + price);
            }
        }
        System.out.println(Arrays.toString(sell));
        return sell[k];
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{3, 2, 6, 5, 0, 3};
        int[] prices = new int[]{2, 4, 1};
        System.out.println(maxProfit2(2, prices));
    }
}