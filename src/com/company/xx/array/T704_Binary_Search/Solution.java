package com.company.xx.array.T704_Binary_Search;

public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (target < nums[0] || target > nums[n - 1]) {
            return -1;
        }
        return recursion(nums, 0, n - 1, target);
    }

    public int recursion(int[] nums, int first, int last, int target) {
        if (first > last) {
            return -1;
        }
        int mid = first + (last - first) >> 2;
        if (nums[mid] > target) {
            return recursion(nums, first, mid - 1, target);
        }
        if (nums[mid] < target) {
            return recursion(nums, mid + 1, last, target);
        }
        return mid;
    }

    public int searchIteration(int[] nums, int target) {
        int n = nums.length;
        if (target < nums[0] || target > nums[n - 1]) {
            return -1;
        }

        int first = 0;
        int last = nums.length - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (nums[mid] > target) {
                last = mid - 1;
            } else if (nums[mid] < target) {
                first = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(s.searchIteration(nums, 9));
    }
}
