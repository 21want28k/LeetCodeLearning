package com.company.xx.剑指offer.剑指Offer_15_二进制中1的个数;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        int m = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & m) != 0) {
                result++;
            }
            m <<= 1;
        }
        return result;
    }

    public int hammingWeight2(int n) {
        int result = 0;
        while (n != 0) {
            n = n & (n - 1);
            result++;
        }
        return result;
    }
}