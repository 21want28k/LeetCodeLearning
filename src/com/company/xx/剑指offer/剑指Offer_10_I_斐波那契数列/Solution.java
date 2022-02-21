package com.company.xx.剑指offer.剑指Offer_10_I_斐波那契数列;

public class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int pre0 = 0;
        int pre1 = 1;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = (pre0 + pre1) % 1000000007;
            pre0 = pre1;
            pre1 = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fib(48));
    }
}
