package com.company.xx.剑指offer.剑指Offer_154_寻找旋转排序数组中的最小值_II;

public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return nums[low];

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 1, 3};
        Solution s = new Solution();
        System.out.println(s.findMin(nums));
    }
}
