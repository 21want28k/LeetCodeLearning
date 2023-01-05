package com.company.xx.DP.T746_使用最小花费爬楼梯;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int one = 0, two = 0;
        for (int i = 2; i <= n; i++) {
            int three = Math.min(one + cost[i - 2], two + cost[i - 1]);
            one = two;
            two = three;
        }
        return two;
    }
}
