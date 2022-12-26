package com.company.xx.array.T977有序数组的平方;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int index = n - 1;
        int low = 0, high = n - 1;
        while (low <= high) {
            if (nums[low] * nums[low] >= nums[high] * nums[high]) {
                res[index] = nums[low] * nums[low];
                low++;
            } else {
                res[index] = nums[high] * nums[high];
                high--;
            }
        }
        return res;
    }
}
