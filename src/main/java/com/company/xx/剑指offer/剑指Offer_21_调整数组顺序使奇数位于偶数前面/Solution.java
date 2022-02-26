package com.company.xx.剑指offer.剑指Offer_21_调整数组顺序使奇数位于偶数前面;

public class Solution {
    /**
     * 首尾指针做法
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int first = 0;
        int last = n - 1;
        while (first < last) {
            // 从后向前找，找到第一个奇数
            while (first < last && (nums[last] & 1) == 0) {
                last--;
            }
            // 从前向后找，找到第一个偶数
            while (first < last && (nums[first] & 1) == 1) {
                first++;
            }
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
        }
        return nums;
    }

    /**
     * 快慢指针，快指针控制遍历, nums[slow, high]这些位置全是偶数，
     * slow代表下一个奇数该存放的位置，fast代表搜索指针，向前搜索找到奇数
     *
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        while (fast < n) {
            if ((nums[fast] & 1) == 1) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
