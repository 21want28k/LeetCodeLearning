package com.company.xx.DP.T70爬楼梯;

public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return n;
        }
        int one = 0;
        int two = 1;
        for (int i = 2; i <= n; i++) {
            int sum = one + two;
            one = two;
            two = sum;
        }
        return two;
    }
}
