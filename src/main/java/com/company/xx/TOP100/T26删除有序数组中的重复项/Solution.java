package com.company.xx.TOP100.T26删除有序数组中的重复项;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int index = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[index - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
