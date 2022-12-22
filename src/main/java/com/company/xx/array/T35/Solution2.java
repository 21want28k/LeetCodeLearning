package com.company.xx.array.T35;

public class Solution2 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (target > nums[n - 1]) {
            return n;
        }
        if (target < nums[0]) {
            return 0;
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
        return low;
    }
}
