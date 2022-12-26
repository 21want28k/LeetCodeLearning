package com.company.xx.array.T283移动零;

public class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return;
        }
        int slow = 0;
        int fast = 1;
        while (fast < n) {
            if (nums[fast] == 0) {
                fast++;
                continue;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        for (int i = slow; i < n; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
    }
}
