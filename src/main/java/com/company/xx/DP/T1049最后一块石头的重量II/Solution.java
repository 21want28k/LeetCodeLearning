package com.company.xx.DP.T1049最后一块石头的重量II;


import java.util.Arrays;

public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = Arrays.stream(stones).sum();
        int totalWeight = sum / 2;
        int[] dp = new int[totalWeight + 1];

//        for (int i = 0; i <= totalWeight; i++) {
//            if (i >= stones[0]) {
//                dp[i] = stones[0];
//            }
//        }

        for (int i = 0; i < n; i++) {
            for (int j = totalWeight; j >= 0; j--) {
                if (j >= stones[i]) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
        }
        return sum - 2 * dp[totalWeight];
    }

    public static void main(String[] args) {
        int[] stones = {21, 60, 61, 20, 31};
        new Solution().lastStoneWeightII(stones);
    }
}
