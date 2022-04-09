package com.company.xx.other.T287寻找重复数;

public class Solution {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        int n = nums.length;
        int slow = 0, fast = 0;
        while (fast != n) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                int head = 0;
                while (slow != head) {
                    slow = nums[slow];
                    head = nums[head];
                }
                return head;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2};
        new Solution().findDuplicate2(nums);
    }
}
