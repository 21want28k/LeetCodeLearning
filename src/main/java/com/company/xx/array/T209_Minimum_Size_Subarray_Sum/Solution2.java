package com.company.xx.array.T209_Minimum_Size_Subarray_Sum;

import java.util.Arrays;

public class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int low = 0, high = 0;
        int sum = 0;
        int min = n + 2;
        while (high < n) {
            while (sum < target && high < n) {
                sum += nums[high++];
            }
            while (sum >= target) {
                min = Math.min(min, high - low);
                sum -= nums[low++];
            }
        }
        return min == n + 2 ? 0 : min;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        int[] sum = new int[n+1];
        int scope = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int j = 1; j <= n; j++) {
            int i = Arrays.binarySearch(sum, sum[j] - target);
            if (i == -1) {
                continue;
            }
            if (i < 0) {
                scope = Math.min(scope, j - (-i - 1 - 1));
            } else {
                scope = Math.min(scope, j - i);
            }
        }
        return scope == Integer.MAX_VALUE ? 0 : scope;
    }


    public static void main(String[] args) {
        int[] nums = {15};
        int target = 15;
        new Solution2().minSubArrayLen2(target, nums);
    }
}
