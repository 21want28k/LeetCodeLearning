package com.company.xx.greed.T55;

public class Solution2 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int index = 0;
        if (n == 1) {
            return true;
        }
        while (nums[index] != 0) {
            int nextScope = index + nums[index];
            if (nextScope > n - 1) {
                return true;
            }
            int maxPos = nextScope;
            for (int j = index; j <= nextScope; j++) {
                if (j + nums[j] > maxPos) {
                    index = j;
                    maxPos = j + nums[j];
                }
            }
            if (maxPos == nextScope) {
                return false;
            }
        }

        return false;
    }


    public boolean canJump2(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[j] + j >= i && dp[j] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        new Solution2().canJump(nums);
    }
}
