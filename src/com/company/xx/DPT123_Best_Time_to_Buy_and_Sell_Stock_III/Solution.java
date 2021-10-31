package com.company.xx.DPT123_Best_Time_to_Buy_and_Sell_Stock_III;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][j][k] 代表第i[1,n]天,是否持有股票[0,1],第k[0,2]次交易的最大收入，规定卖出的时候交易次数+1
        int[][][] dp = new int[n + 1][2][3];

        for (int k = 0; k <= 2; k++) {
            dp[1][0][k] = 0;
            dp[1][1][k] = -prices[0];
        }

        for (int i = 2; i < n + 1; i++) {
            int price = prices[i - 1];
            for (int j = 0; j <= 2; j++) {
                // 第0次交易
                if (j == 0) {
                    dp[i][0][j] = dp[i - 1][0][j];
                } else {
                    // 今天不持有 = max(昨天不持有，昨天持有状态+今天卖出)
                    dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] + price);
                }
                // 今天持有 = max(昨天持有，昨天不持有状态+今天买入)
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] - price);
            }
        }
        List<Integer> list = new ArrayList<>();
        System.out.println(Arrays.deepToString(dp));
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 2; j++) {
                // dp[n][0][0], dp[n][1][0], dp[n][0][1], dp[n][1][1], dp[n][0][2], dp[n][1][2]
                list.add(dp[n][i][j]);
            }
        }
        return Collections.max(list);
    }

    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        // dp[i][j]代表第i天，
        // j代表第i天第状态，共五种。
        // - 0：当天无交易
        // - 1：第一次买入
        // - 2：第一次卖出
        // - 3：第二次买入
        // - 4：第二次卖出
        int[][] dp = new int[n + 1][5];

        // initialization
        for (int i = 0; i < dp[0].length; i++) {
            if (i % 2 == 1) {
                dp[1][i] = -prices[0];
            }
        }
        for (int i = 2; i < n + 1; i++) {
            int price = prices[i - 1];
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j <= 4; j++) {
                // j is odd
                if (j % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - price);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + price);
                }
            }
//            // 第i天第一次买入 = max(当天无操作，当天买入)，dp[i - 1][0]代表前一天处于无操作下的最大收入。不处于无操作状态，就不能第一次买入。
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - price);
//            // 第i天第一次卖出 = max(当天无操作，当天卖出)，dp[i - 1][1]代表前一天处于买入状态下的最大收入。不处于买入状态，就不能第一次买入。
//            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + price);
//            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - price);
//            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + price);
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][4];
    }

    public static int maxProfit3(int[] prices) {
        int n = prices.length;
        // dp[i][j]代表第i天，
        // j代表第i天第状态，共五种。
        // - 0：当天无交易
        // - 1：第一次买入
        // - 2：第一次卖出
        // - 3：第二次买入
        // - 4：第二次卖出
        int[][] dp = new int[n + 1][5];
        int nothing = 0;
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;

        for (int i = 2; i < n + 1; i++) {
            int price = prices[i - 1];
            buy1 = Math.max(buy1, nothing - price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit2(prices));
    }
}