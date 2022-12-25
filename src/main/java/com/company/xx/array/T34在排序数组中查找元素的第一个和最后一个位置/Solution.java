package com.company.xx.array.T34在排序数组中查找元素的第一个和最后一个位置;

import java.util.ArrayList;

public class Solution {
    /**
     * 找到第一个== target值的位置，如果没有就返回第一个>target的位置（也就是需要插入的地方）
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int pos = n;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= target) {
                pos = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return pos;
    }

    /**
     * 找到第一个> target值的位置，这里是严格大于
     */
    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int pos = n;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                pos = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return pos;
    }

    /**
     * 找到最后一个>=target的数,找不到就返回最后一个< target的数字
     */
    public int searchInsert3(int[] nums, int target) {
        int n = nums.length;
        int pos = n;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                pos = mid;
                low = mid + 1;
            }
        }
        return pos;
    }

    /**
     * 找到最后一个< target的数字
     */
    public int searchInsert4(int[] nums, int target) {
        int n = nums.length;
        int pos = n;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                pos = mid;
                low = mid + 1;
            }
        }
        return pos;
    }

    public int[] searchRange(int[] nums, int target) {
        int left = searchInsert(nums, target);
        int right = searchInsert3(nums, target);
        if (left == right) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(new Solution().searchInsert3(nums, 4));
    }
}
