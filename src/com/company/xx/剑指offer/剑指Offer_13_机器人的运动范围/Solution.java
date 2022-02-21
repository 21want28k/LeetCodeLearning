package com.company.xx.剑指offer.剑指Offer_13_机器人的运动范围;

import java.util.Arrays;

public class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        int sum = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0 || sum(i, j) > k) {
                    continue;
                }
                if (i >= 1) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if (j >= 1) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
                if (dp[i][j]) {
                    sum++;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return sum;
    }

    public int sum(int i, int j) {
        char[] sI = String.valueOf(i).toCharArray();
        char[] sJ = String.valueOf(j).toCharArray();
        int sum = 0;
        for (char c : sI) {
            sum += c - '0';
        }
        for (char c : sJ) {
            sum += c - '0';
        }
        return sum;
    }

    public int get(int i) {
        int result = 0;
        while (i != 0) {
            result += i % 10;
            i = i / 10;
        }
        return result;
    }


    // 图的DFS算法，之后再专门研究
    int result;
    int m, n;

    public int movingCount2(int m, int n, int k) {
        this.m = m;
        this.n = n;
        dfs(0, 0, k);
        return result;
    }

    public void dfs(int i, int j, int k) {
        if (sum(i, j) > k || i >= m || j >= n) {
            return;
        }
        result++;
        dfs(i + 1, j, k);
        dfs(i, j + 1, k);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.get(89));
        System.out.println(s.movingCount2(3, 2, 17));
    }
}