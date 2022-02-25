package com.company.xx.剑指offer.剑指Offer_63_股票的最大利润;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;
    }
}
