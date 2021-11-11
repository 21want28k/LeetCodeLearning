package com.company.xx.DP_1035_Uncrossed_Lines;

public class Solution {
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 4, 2};
//        int[] nums2 = new int[]{1, 2, 4};
        int[] nums1 = new int[]{2, 5, 1, 2, 5};
        int[] nums2 = new int[]{10, 5, 2, 1, 5, 2};
        System.out.println(maxUncrossedLines(nums1, nums2));
    }
}
