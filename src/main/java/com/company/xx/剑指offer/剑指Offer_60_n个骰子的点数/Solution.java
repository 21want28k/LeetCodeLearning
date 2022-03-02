package com.company.xx.剑指offer.剑指Offer_60_n个骰子的点数;

import java.util.Arrays;

public class Solution {
    public double[] dicesProbability(int n) {
        // dp[i,j]
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1.0 / 6;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j <= (i - 1) * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    dp[i][j + k] += dp[i - 1][j] * 1 / 6;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return Arrays.copyOfRange(dp[n], n, 6 * n + 1);
    }

    public double[] dicesProbability2(int n) {
        double[] pre = new double[6];
//        for (int i = 0; i < 6; i++) {
//            dp[i] = 1.0 / 6;
//        }
        Arrays.fill(pre, 1.0 / 6);
        for (int i = 2; i <= n; i++) {
            double[] cur = new double[5 * i + 1];
            for (int j = 0; j < pre.length; j++) {
                for (int k = 0; k < 6; k++) {
                    cur[j + k] += pre[j] * 1 / 6;
                }
            }
            pre = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dicesProbability(2)));
    }
}
