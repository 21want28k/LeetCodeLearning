package com.company.xx.array.T35;

public class Solution {
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

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert2(nums, target));
    }
}
