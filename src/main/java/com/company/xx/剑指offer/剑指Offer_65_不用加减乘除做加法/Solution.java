package com.company.xx.剑指offer.剑指Offer_65_不用加减乘除做加法;

public class Solution {
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add(a ^ b, (b & a) << 1);
    }
}
