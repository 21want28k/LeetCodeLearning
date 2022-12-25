package com.company.xx.array.T27_Remove_Element;

public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            while (start <= end && nums[start] != val) { // 从左向右，找到第一个=value的位置
                start++;
            }
            while (start <= end && nums[end] == val) { // 从右向左，找到第一个!=value的位置
                end--;
            }
            if (start < end) {
                nums[start] = nums[end];
                nums[end] = val;
            }
        }
        return start + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        new Solution2().removeElement(nums, 3);
    }
}
