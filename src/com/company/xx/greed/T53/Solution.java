package com.company.xx.greed.T53;

public class Solution {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;

        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < n; i++) {
            if (pre < 0) {
                pre = nums[i];
            } else {
                pre += nums[i];
            }
            max = Math.max(max, pre);
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int n = nums.length;

        int pre = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            pre += num;
            max = Math.max(pre, max);
            if (pre < 0) {
                pre = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = new int[]{-2, 1};
        int[] nums = new int[]{-1};
        System.out.println(maxSubArray2(nums));
    }
}
