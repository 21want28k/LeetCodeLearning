package com.company.xx.DP.T416_DP_Partition_Equal_Subset_Sum;

import java.util.Arrays;

public class Solution2 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int sumWeight = sum / 2;
        boolean[] dp = new boolean[sumWeight + 1];
        dp[0] = true;
        if (nums[0] < sumWeight){
            dp[nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = sumWeight; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sumWeight];
    }

    public static void main(String[] args) {
        new Solution2().canPartition(new int[]{1, 5, 11, 5});
    }
}
