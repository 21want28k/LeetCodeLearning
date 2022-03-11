package com.company.xx.剑指offer.剑指Offer_62_圆圈中最后剩下的数字;

public class Solution {
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
