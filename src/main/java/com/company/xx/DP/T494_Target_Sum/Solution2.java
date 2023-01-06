package com.company.xx.DP.T494_Target_Sum;

import java.util.Arrays;

public class Solution2 {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0);
        return count;
    }

    public void dfs(int[] nums, int target, int begin) {
        if (begin == nums.length) {
            if (target == 0) {
                count++;
            }
            return;
        }
        dfs(nums, target - nums[begin], begin + 1);
        dfs(nums, target + nums[begin], begin + 1);
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 != 0 || sum + target < 0) {
            return 0;
        }
        int totalW = (sum + target / 2);
        int[] dp = new int[totalW + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = totalW; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[totalW];
    }

    public static void main(String[] args) {

    }
}
