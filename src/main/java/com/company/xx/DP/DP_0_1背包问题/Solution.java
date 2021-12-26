package com.company.xx.DP.DP_0_1背包问题;


import java.util.Arrays;

public class Solution {
    public static int bag(int[] weights, int[] value, int bagWeight) {
        int n = weights.length;
        int m = bagWeight;

        // 物品编号：0~n-1 背包重量0~m
        int[][] dp = new int[n][m + 1];

        // initialization，
        // We can ignore initialize 0 in this array for the sake that java language will initialize int array by 0.
        // In this array, some zero value will be replaced during the loop.
        // 初始化0的过程java可以省略，因为int数组默认初始化为0，二维数组中间部分也可以不手动初始化，因为自动初始化为0
        // 并且所有的值后面会改动
        for (int j = 0; j < m + 1; j++) {
            if (j >= weights[0]) {
                dp[0][j] = value[0];
            } else {
                dp[0][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m + 1; j++) {
                // 放入i号物品的时候
                if (j >= weights[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i]] + value[i], dp[i - 1][j]);
                } else {
                    // 不放入i号物品
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][m];
    }

    /**
     * improve the space complexity from O(N*M) into O(M)
     */
    public static int bag2(int[] weights, int[] value, int bagWeight) {
        int n = weights.length;
        int m = bagWeight;

        int[] dp = new int[m + 1];

        // initialization，
        // Actually, there is no need for one-dimensional array to be initialized for the sake of loop.
        for (int j = 0; j < m + 1; j++) {
            if (j > weights[0]) {
                dp[j] = value[0];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j >= weights[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + value[i]);
                }
            }
        }

        // Try to swap the loop condition, the consequence seems not the same as imaged.
        // One bag is packed by only one article.
//        for (int j = m; j >= 0; j--) {
//            for (int i = 0; i < n; i++) {
//                if (j >= weights[i]) {
//                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + value[i]);
//                }
//            }
//        }

        System.out.println(Arrays.toString(dp));
        return dp[m];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 3, 4, 5};
        int[] value = new int[]{1, 4, 5, 7};
        bag2(weights, value, 7);
//        int[] weights = new int[]{1, 3, 4};
//        int[] value = new int[]{15, 20, 30};
//        bag(weights, value, 4);
    }
}