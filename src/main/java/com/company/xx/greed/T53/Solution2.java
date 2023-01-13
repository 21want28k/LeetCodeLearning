package com.company.xx.greed.T53;

public class Solution2 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < n; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
