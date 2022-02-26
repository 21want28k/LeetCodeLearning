package com.company.xx.DP.T198_DP_House_Robber;


import java.util.Arrays;

public class Solution {
    public static int rob(int[] nums) {
        int n = nums.length;
        // 1~n 存储值，0不算
        int[] dp = new int[n + 1];
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static int rob2(int[] nums) {
        int n = nums.length;
        // 1~n 存储值，0不算
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= n; i++) {
            int current = Math.max(second, first + nums[i - 1]);
            first = second;
            second = current;
        }
        return second;
    }

    /**
     * 利用股票里面的思想可以这么做
     *
     * @param nums
     * @return
     */
    public static int rob3(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][2];
        // 不偷
        dp[0][0] = 0;
        // 偷
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
        }

        System.out.println(Arrays.deepToString(dp));
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * rob3解法的优化,错误的解法，新一轮依赖的旧值已经被更改了，就不能这么写了。
     *
     * @param nums
     * @return
     */
    public static int rob4(int[] nums) {
        int n = nums.length;

        int notRob = 0;
        int rob = nums[0];

        for (int i = 1; i < n; i++) {
            notRob = Math.max(notRob, rob);
            rob = Math.max(rob, notRob + nums[i]);
        }

        return rob;
    }

    /**
     * 修改rob4的做法，用pre代表上一个依赖的结果即可。
     * @param nums
     * @return
     */
    public static int rob5(int[] nums) {
        int n = nums.length;

        int notRob = 0;
        int rob = nums[0];
        int preNotRob;
        int preRob;
        for (int i = 1; i < n; i++) {
            preRob = rob;
            preNotRob = notRob;
            notRob = Math.max(preNotRob, preRob);
            rob = Math.max(preRob, preNotRob + nums[i]);
        }

        return rob;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 1};
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob4(nums));
    }
}