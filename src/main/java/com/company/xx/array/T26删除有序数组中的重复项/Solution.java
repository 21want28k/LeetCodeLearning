package com.company.xx.array.T26删除有序数组中的重复项;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 1; // slow永远指向待填入的那个位置
        int fast = 1; // fast遍历
        while (fast < nums.length) {
            if (nums[fast] == nums[slow - 1]) { // slow-1是上一个已经填好的位置
                fast++;
                continue;
            }
            // 找到不同了填入slow的位置
            nums[slow++] = nums[fast++];
        }
        return slow;
    }
}
