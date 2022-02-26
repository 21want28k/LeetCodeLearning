package com.company.xx.DP.T55_跳跃问题;

import java.util.Arrays;

/**
 * 属于存在性问题，动态规划四步骤，
 * 1。最后一步；
 * 2。转换为子问题；
 * 3。写出转移方程；
 * 4。定初始值，注意边界情况，看是从小到大算，还是从大到小，到看状态转移方程
 */
public class Demo {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        boolean result[] = new boolean[n];
        // 初始条件
        result[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 能不能到j上，并且能不能从j的位置跳到i的位置
                if (result[j] == true && (i - j) <= nums[j]) {
                    result[i] = true;
                    break;
                } else {
                    result[i] = false;
                }
            }
        }
        return result[n - 1];
    }

    public static boolean canJump2(int[] nums) {
        int n = nums.length;

        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (dp[j] == true) {
                    dp[i] = true;
                    break;
                } else {
                    dp[i] = false;
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static boolean canJump3(int[] nums) {
        int n = nums.length;
        boolean[] results = new boolean[n];
        if (n == 1) {
            return true;
        }

        if (nums[0] == 0) {
            return false;
        }

        results[0] = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && i + 1 < n && results[i + 1] == false) {
                return false;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j <= n - 1) {
                    results[i + j] = true;
                }
            }
        }
        System.out.println(Arrays.toString(results));
        return results[n - 1];
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 0, 0};
//        int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums = new int[]{1, 0, 1, 0};
        System.out.println(canJump3(nums));
    }
}