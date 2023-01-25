package com.company.xx.TOP100.T33搜索旋转排序数组;

public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 前一半有序
            if (nums[left] <= nums[mid]) {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // 后一半有序
                if (nums[mid] < target && nums[mid] <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        int target = 8;
        new Solution().search(nums, target);
    }
}
