package com.company.xx.array.T209_Minimum_Size_Subarray_Sum;

import java.util.Arrays;

public class Solution {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = -1;
        int sum = 0;
        while (start < n) {
            while (sum < target && end != n - 1) {
                end++;
                sum += nums[end];
            }
            if (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
            }
            sum -= nums[start];
            start++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int minSubArrayLen3(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int minLength = Integer.MAX_VALUE;
        int[] prefix = new int[n]; // prefix[i] : nums[0:i] 之和
        int sum = 0;
        // fill prefix[]
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
        for (int i = 0; i < n; i++) {
            int val = (i == 0 ? target : target + prefix[i - 1]);
            int bound = Arrays.binarySearch(prefix, val); // bound = -insertion point - 1
            // can't find the val
            if (bound < 0) {
                bound = -bound - 1;
            }
            // if find the val, the scope of bound is from 0 to n-1. [0:n-1]
            if (bound <= n - 1) {
                minLength = Math.min(minLength, bound - i + 1);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int minSubArrayLen4(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen3(target, nums));
    }
}
