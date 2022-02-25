package com.company.xx.剑指offer.剑指Offer_64_;

public class Solution {
    int result = 0;

    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        result += n;
        return result;
    }
}
