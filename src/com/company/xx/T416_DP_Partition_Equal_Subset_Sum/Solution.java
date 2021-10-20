package com.company.xx.T416_DP_Partition_Equal_Subset_Sum;

public class Solution {
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int m = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        m = sum / 2;

        // x:0～n-1 y:0~m
        boolean[][] dp = new boolean[n][m + 1];
        // initialization
        for (int j = 0; j < m + 1; j++) {
            if (nums[0] == j) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][m];
    }

    // space optimization
    public static boolean canPartition2(int[] nums) {
        int n = nums.length;
        int m = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        m = sum / 2;

        boolean[] dp = new boolean[m + 1];
//        dp[0] = true;
        for (int i = 0; i < m + 1; i++) {
            if (i == nums[0]) {
                dp[i] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
                // do nothing if j < nums[i]
            }
        }
        return dp[m];
    }

    // code optimization
    public static boolean canPartition3(int[] nums) {
        int n = nums.length;
        int m = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        m = sum / 2;

        boolean[] dp = new boolean[m + 1];
        // Although this doesn't match dp definition, but it matches the reality. if j-nums[i] == 0, the num[i] is one set,
        // and the others can construct another set.
        dp[0] = true;
        for (int i = 0; i < m + 1; i++) {
            if (i == nums[0]) {
                dp[i] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
                // do nothing if j < nums[i]
            }
        }
        return dp[m];
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{1, 5, 11, 5};
        int[] nums = new int[]{1, 1};
//        int[] nums = new int[]{1, 2, 3, 5};
        System.out.println(canPartition2(nums));
    }
}
