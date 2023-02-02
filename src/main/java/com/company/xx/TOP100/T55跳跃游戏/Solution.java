package com.company.xx.TOP100.T55跳跃游戏;

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && end == i) {
                return false;
            }
            end = Math.max(end, i + nums[i]);
            if (end > n - 1) {
                return true;
            }
        }
        return false;
    }
}
