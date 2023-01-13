package com.company.xx.greed.T1005;

import java.util.Arrays;

public class Solution2 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n && k > 0; i++) {
            if (nums[i] <= 0) {
                k--;
                nums[i] = -nums[i];
            } else if (nums[i] > 0) {
                if (k % 2 == 0) {
                    break;
                } else {
                    if (i > 1) {
                        if (nums[i] > nums[i - 1]) {
                            nums[i - 1] = -nums[i - 1];
                        } else {
                            nums[i] = -nums[i];
                        }
                    } else {
                        nums[i] = -nums[i];
                    }
                    k = 0;
                }
            }
        }
        if (k > 0 && k % 2 == 1) {
            nums[n - 1] = -nums[n - 1];
        }
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, -3};
        new Solution2().largestSumAfterKNegations(nums, 4);
    }
}
