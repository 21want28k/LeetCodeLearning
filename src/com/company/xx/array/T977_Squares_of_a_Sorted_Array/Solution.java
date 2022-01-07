package com.company.xx.array.T977_Squares_of_a_Sorted_Array;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int first = 0;
        int last = n - 1;
        int[] result = new int[n];
        int index = n - 1;
        while (first <= last) {
            if (nums[first] * nums[first] > nums[last] * nums[last]) {
                result[index--] = nums[first] * nums[first];
                first++;
            } else {
                result[index--] = nums[last] * nums[last];
                last--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        Solution s = new Solution();
        s.sortedSquares(nums);
    }
}
