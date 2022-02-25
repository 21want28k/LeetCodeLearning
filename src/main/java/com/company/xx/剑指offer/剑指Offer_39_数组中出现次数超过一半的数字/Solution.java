package com.company.xx.剑指offer.剑指Offer_39_数组中出现次数超过一半的数字;

public class Solution {
    /**
     * 如果说不存在众数到时候，要通过遍历数组去检查
     * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int votes = 0;
        int majorElement = nums[0];
        for (int num : nums) {
            if (votes != 0) {
                if (num == majorElement) {
                    votes++;
                } else {
                    votes--;
                }
            } else {
                majorElement = num;
                votes = 1;
            }
        }
        return majorElement;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nums));
    }
}
