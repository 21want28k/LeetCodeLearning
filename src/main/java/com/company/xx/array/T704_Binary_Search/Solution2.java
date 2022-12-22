package com.company.xx.array.T704_Binary_Search;

public class Solution2 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (target < nums[0] || target > nums[n - 1]) {
            return -1;
        }
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
