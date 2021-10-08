package com.company.xx.T746_使用最小花费爬楼梯;


/**
 * 示例1中，最后一步可以理解为不用花费体力就可以爬到楼顶。动手模拟一下就可以看出，某一个位置只能由前两个一步/两步走上来，只需要比较这两个位置的花费
 * 就可以得到当前位置的最小值。是爬楼梯的升级版
 */
public class Demo {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        // 因为最后一步不需要花费体力，所以选倒数第一步和第二步的最小值
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    // 只用到前两个状态，所以可以进行优化
    public static int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int dp0 = cost[0];
        int dp1 = cost[1];
        int min = 0;
        for (int i = 2; i < n; i++) {
            min = Math.min(dp0, dp1) + cost[i];
            dp0 = dp1;
            dp1 = min;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs2(cost));
    }
}