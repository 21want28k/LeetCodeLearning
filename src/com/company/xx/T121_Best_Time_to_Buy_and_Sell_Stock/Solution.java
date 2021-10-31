package com.company.xx.T121_Best_Time_to_Buy_and_Sell_Stock;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int max = 0;
        // i范围[1,n]
        int[] dp = new int[n + 1]; // 前i-1天（包括i-1）买入，第i天卖出获得的收入
        for (int i = 2; i < n + 1; i++) {
            if (min > prices[i - 2]) {
                min = prices[i - 2];
            }
            dp[i] = prices[i - 1] - min;
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int max = 0;
        // i范围[1,n]
        int[] dp = new int[n + 1]; // 前i天（包括i）天的历史最低值
        dp[1] = prices[0];
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i - 1]);
            int cur = prices[i - 1] - dp[i];
            max = Math.max(cur, max);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static int maxProfit3(int[] prices) {
        int n = prices.length;
        int max = 0;
        // i范围[1,n]
        int min = prices[0];
        for (int i = 2; i < n + 1; i++) {
            min = Math.min(min, prices[i - 1]);
            int cur = prices[i - 1] - min;
            max = Math.max(cur, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
//        int[] prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit3(prices));
    }
}
