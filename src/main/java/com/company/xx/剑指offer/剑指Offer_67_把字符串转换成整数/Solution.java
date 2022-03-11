package com.company.xx.剑指offer.剑指Offer_67_把字符串转换成整数;

public class Solution {
    public int strToInt(String str) {
        int bound = Integer.MAX_VALUE / 10;
        int res = 0;
        int n = str.length();
        if (n == 0) {
            return res;
        }
        int sign = 1;
        int i = 0;
        while (str.charAt(i) == ' ') {
            i++;
            if (i == n) {
                return res;
            }
        }

        if (str.charAt(i)  == '+') {
            i++;
        } else if (str.charAt(i)  == '-') {
            sign = -1;
            i++;
        }
        for (int j = i; j < n; j++) {
            if (str.charAt(j)  < '0' || str.charAt(j) > '9') {
                break;
            }
            if (res > bound || (res == bound && str.charAt(j) > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + str.charAt(j) - '0';
        }
        return res * sign;
    }
}
