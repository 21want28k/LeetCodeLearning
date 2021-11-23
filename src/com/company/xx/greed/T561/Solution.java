package com.company.xx.greed.T561;

import java.util.Arrays;

public class Solution {

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6, 2, 6, 5, 1, 2};
        System.out.println(arrayPairSum(nums));
    }
}
