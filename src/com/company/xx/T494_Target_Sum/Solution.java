package com.company.xx.T494_Target_Sum;

import java.util.Arrays;

public class Solution {
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < target) {
            return 0;
        }
        // 正整数和是x，负整数的和为y，
        // x-y = target，x+y = sum；x=sum-y
        // sum-2y = target， y = (sum-target)/2
        if ((sum - target) % 2 == 1) {
            return 0;
        }
        int y = (sum - target) / 2;
        System.out.println(y);

        // 行0~n,列0~y 要想明白为什么是0～n，因为把总和为0不选元素当成了一种方案。第一行，代表，没有元素选出和为j。
        // 如果是0～n-1，第一行的dp[][nums[i]] = 2;
        int[][] dp = new int[n + 1][y + 1];
        //initialization,dp[0][0] = 1, the others is 0
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < y + 1; j++) {
                int num = nums[i - 1];
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][y];
    }

    public static int findTargetSumWays2(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < target) {
            return 0;
        }
        // 正整数和是x，负整数的和为y，
        // x-y = target，x+y = sum；x=sum-y
        // sum-2y = target， y = (sum-target)/2
        if ((sum - target) % 2 == 1) {
            return 0;
        }
        int y = (sum - target) / 2;

        int[] dp = new int[y + 1];
        // 就代表无数字的时候，满足和为0，种类数目为1
        dp[0] = 1;
        // 从第一个数字开始便利
        for (int i = 0; i < n; i++) {
            for (int j = y; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
            // 小于的时候不用修改值，继承上一回的值。
        }
        return dp[y];
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 1, 1, 1};
        int[] nums = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(findTargetSumWays2(nums, 1));
        // test commit
    }
}
