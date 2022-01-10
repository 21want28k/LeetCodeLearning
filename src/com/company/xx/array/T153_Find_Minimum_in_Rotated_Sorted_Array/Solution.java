package com.company.xx.array.T153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {
    public static int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 1, 2};
//        System.out.println(3 + (4 - 3) >> 1);
        System.out.println(findMin(nums));
    }
}
