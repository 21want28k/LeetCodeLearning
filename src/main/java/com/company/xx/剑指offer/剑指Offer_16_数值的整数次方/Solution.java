package com.company.xx.剑指offer.剑指Offer_16_数值的整数次方;

public class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        boolean flag = true;
        long a = n;
        if (a < 0) {
            flag = false;
            a = -a;
        }
        while (a > 0) {
            if ((a & 1) == 1) {
                res *= x;
            }
            x = x * x;
            a >>= 1;
        }
        return flag ? res : 1 / res;
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(new Solution().myPow(x, n));
    }
}