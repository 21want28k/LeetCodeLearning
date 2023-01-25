package com.company.xx.TOP100.T34在排序数组中查找元素的第一个和最后一个位置;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = n - 1;
        int pos1 = -1;
        int pos2 = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                pos1 = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                pos2 = mid;
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{pos1, pos2};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        new Solution().searchRange(nums, target);
    }
}
