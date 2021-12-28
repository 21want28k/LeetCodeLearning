package com.company.xx.DP.T62_不同路径问题;

public class Demo {
    public int uniquePaths(int m, int n) {
        // 行0~m-1，列0～n-1
        int f[][] = new int[m][n];

        // 初始化
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 转移方程
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}