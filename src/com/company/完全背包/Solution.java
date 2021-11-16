package com.company.完全背包;

import java.util.Arrays;

public class Solution {

    public static int method(int[] weights, int[] values, int bagWeight) {
        int n = weights.length;

        int[][] dp = new int[n + 1][bagWeight + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j - weights[i - 1]] + values[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][bagWeight];
    }

    public static int method2(int[] weights, int[] values, int bagWeight) {
        int n = weights.length;

        int[][] dp = new int[n + 1][bagWeight + 1];

        for (int j = 0; j <= bagWeight; j++) {
            for (int i = 1; i <= n; i++) {
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j - weights[i - 1]] + values[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][bagWeight];
    }

    public static int method3(int[] weights, int[] values, int bagWeight) {
        int n = weights.length;

        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < n; i++) {
            for (int j = weights[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[bagWeight];
    }

    public static int method4(int[] weights, int[] values, int bagWeight) {
        int n = weights.length;

        int[] dp = new int[bagWeight + 1];
        for (int j = 0; j <= bagWeight; j++) {
            for (int i = 0; i < n; i++) {
                if (j >= weights[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[bagWeight];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 3, 4};
        int[] values = new int[]{15, 20, 30};
        int bagWeight = 4;
//        int[] weights = new int[]{2, 3, 4, 7};
//        int[] values = new int[]{1, 3, 5, 9};
//        int bagWeight = 10;

        System.out.println(method3(weights, values, bagWeight));
    }
}
