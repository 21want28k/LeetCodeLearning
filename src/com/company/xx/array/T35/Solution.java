package com.company.xx.array.T35;

public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int pos = 0;
        int n = nums.length;

        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (target > nums[mid]) {
                pos = mid;
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        if (pos == 0 && target < nums[0]) {
            return pos;
        } else {
            return pos + 1;
        }
    }

    public static int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int pos = n;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                pos = mid;
                right = mid - 1;
            }
        }
        return pos;
    }

    public int searchInsert3(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert2(nums, target));
    }
}
