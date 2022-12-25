package com.company.xx.array.T80删除有序数组中的重复项II;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[fast] == nums[slow - 2]) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 3, 3};
        new Solution().removeDuplicates(nums);
    }
}


