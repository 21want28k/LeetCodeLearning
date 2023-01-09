package com.company.xx.DP.T_279_erfect_Squares;

public class Solution2 {
    public int numSquares(int n) {
        int num = (int) Math.sqrt(n);
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = (i + 1) * (i + 1);
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < num; i++) {
            for (int j = nums[i]; j <= n; j++) {
//                if (j >= nums[i])
                    dp[j] = Math.min(dp[j],dp[j-nums[i]] +1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println((int) Math.sqrt(15));
    }
}
