package com.company.xx.剑指offer.剑指Offer_57_和为s的两个数字;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int head = 0;
        int tail = n - 1;
        int[] result = new int[2];
        while (head < tail) {
            if (nums[head] > target - nums[tail]) {
                tail--;
            } else if (nums[head] < target - nums[tail]) {
                head++;
            } else {
                result[0] = nums[head];
                result[1] = nums[tail];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.run();
    }
}
