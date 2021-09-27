package com.company.xx.青蛙跳台阶问题;

public class Demo {
    public static int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // 0~n
        int f[] = new int[n + 1];

        // 初始值，一开始在地上，不是在第一级台阶上
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % 1000000007;
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}