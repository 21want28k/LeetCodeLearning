package com.company.xx.greed.T122;

public class Solution {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            int minus = prices[i] - prices[i - 1];
            if (minus > 0) {
                sum += minus;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
