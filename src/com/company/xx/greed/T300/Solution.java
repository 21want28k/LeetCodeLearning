package com.company.xx.greed.T300;

import java.util.Arrays;

public class Solution {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // d[i]代表长度为i的子数组的最后一个数的最小值，有效范围1~n
        int[] d = new int[n + 1];
        int len = 1;
        d[1] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                len++;
                d[len] = nums[i];
            } else {
                // 在d[]数组中二分查找第一个比nums[i]大的数字
                int left = 1;
                int right = len;
                int pos = len;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (d[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        pos = mid;
                        right = mid - 1;
                    }
                }
                d[pos] = nums[i];
            }
        }
        return len;
    }

    public static int[] lengthOfLIS2(int[] nums) {
        int n = nums.length;
        // d[i]代表长度为i的子数组的最后一个数的最小值，有效范围1~n
        int[] d = new int[n + 1];
        int len = 1;
        d[1] = nums[0];
        int[] dp = new int[n]; // dp[i]:代表以nums[i]结尾的最长子数组的长度为dp[i]
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                len++;
                d[len] = nums[i];
                dp[i] = len;
            } else {
                // 在d[]数组中二分查找第一个比nums[i]大的数字
                int left = 1;
                int right = len;
                int pos = len;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (d[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        pos = mid;
                        right = mid - 1;
                    }
                }
                d[pos] = nums[i];
                dp[i] = pos;
            }
        }
        System.out.println(Arrays.toString(dp));

        int[] result = new int[len];
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == len) {
                result[len - 1] = nums[i];
                len--;
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
    public static void main(String[] args) {
//        int[] nums = new int[]{0, 8, 4, 12, 2};
        int[] nums = new int[]{0, 8, 4, 12, 2, 4, 1};
        System.out.println(lengthOfLIS2(nums));
    }
}
