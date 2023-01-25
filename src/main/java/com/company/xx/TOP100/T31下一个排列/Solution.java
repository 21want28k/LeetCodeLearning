package com.company.xx.TOP100.T31下一个排列;

public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        i--;
        if (i >= 0) {
            int j = n - 1;
            while (j > 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // i<0的时候就说明序列是完全递减的，只需要重新排序就行
        // 比如[3,2,1]完全递减，只需要变成[1,2,3]就行
        int start = i + 1;
        int end = n - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1};
        new Solution().nextPermutation(nums);
    }
}
