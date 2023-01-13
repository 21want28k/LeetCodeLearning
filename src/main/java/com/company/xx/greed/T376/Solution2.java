package com.company.xx.greed.T376;

public class Solution2 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return n;
        }
        int curDiff = 0;
        int preDiff = 0;
        int res = 1;
        for (int i = 1; i < n; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }

    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return n;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
                if (nums[i] < nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        new Solution2().wiggleMaxLength(nums);
    }
}
