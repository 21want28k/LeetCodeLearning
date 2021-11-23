package com.company.xx.DP.T300_Longest_Increasing_Subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1]; // dp[i]代表前i个（包括i且i必须选）数字的最长子序列
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    /**
     * 输出递增子序列
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1]; // dp[i]代表前i个（包括i且i必须选）数字的最长子序列
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        int[] arrys = new int[max];
        int min = Integer.MAX_VALUE;

        int end = n;
        // 遍历dp
        while (max >= 1) {
            for (int i = end; i >= 1; i--) {
                if (dp[i] == max) {
                    if (nums[i - 1] < min) {
                        end = i - 1;
                        min = nums[i - 1];
                    }
                }
            }
            arrys[max - 1] = min;
            max--;
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(arrys));
        return 0;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 0, 3, 2, 3};
//        int[] nums = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
//        int[] nums = new int[]{1, 2, 8, 6, 4};
//        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = new int[]{0, 8, 4, 12, 2, 4, 1};
        System.out.println(lengthOfLIS2(nums));
    }
}
