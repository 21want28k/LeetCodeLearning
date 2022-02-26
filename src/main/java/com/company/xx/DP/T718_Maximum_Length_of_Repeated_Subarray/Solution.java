package com.company.xx.DP.T718_Maximum_Length_of_Repeated_Subarray;

import java.util.Arrays;

public class Solution {
    public static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // n : 1~n
        // m : 1~m
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return max;
    }

    public static int findLength2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // n : 1~n
        // m : 1~m
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (nums2[0] == nums1[i]) {
                dp[i][0] = 1;
            }
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return max;
    }

    /**
     * 滚动数组
     */
    public static int findLength3(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] dp = new int[m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                max = Math.max(dp[j], max);
            }
        }
        return max;
    }

    /**
     * 新的思路，但是是错误的解法，对比T1143
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findLength4(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1]; // dp[i][j]: nums1:[0:i],nums2:[0:j]的最长连续子数组的长度是dp[i][j]

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[n][m];
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 2, 3, 2, 1};
//        int[] nums2 = new int[]{3, 2, 1, 4, 7};
        int[] nums1 = new int[]{0, 1, 1, 1, 1};
        int[] nums2 = new int[]{1, 0, 1, 0, 1};
        System.out.println(findLength2(nums1, nums2));
        System.out.println(findLength4(nums1, nums2));
    }
}