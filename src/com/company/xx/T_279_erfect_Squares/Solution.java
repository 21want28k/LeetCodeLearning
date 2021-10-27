package com.company.xx.T_279_erfect_Squares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int numSquares(int n) {
        List<Integer> list = getNum(n);
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 0;
        }

        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j <= n; j++) {
                int num = list.get(i);
                if (j >= num) {
                    dp[j] = Math.min(dp[j], dp[j - num] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    public static List<Integer> getNum(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n / 2; i++) {
            if (i * i <= n) {
                list.add(i * i);
            }
        }
        System.out.println(list);
        return list;
    }

    public static int numSquares2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] < Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }


    public static void main(String[] args) {
        numSquares2(4);
    }
}