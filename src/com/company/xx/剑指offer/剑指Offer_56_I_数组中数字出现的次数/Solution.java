package com.company.xx.剑指offer.剑指Offer_56_I_数组中数字出现的次数;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        // 异或，初始化为0不会影响到结果
        int a_b = 0;
        int m = 1;
        int x = 0, y = 0;
        for (int j : nums) {
            a_b ^= j;
        }
        while ((m & a_b) == 0) {
            m = m << 1;
        }
        for (int num : nums) {
            if ((m & num) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
