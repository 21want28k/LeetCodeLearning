package com.company.xx.剑指offer.剑指Offer_56_II_数组中数字出现的次数_II;

public class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int[] count = new int[32];
        int m = count.length;
        int number = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count[j] += nums[i] & 1;
                nums[i] >>>= 1;
            }
        }
        for (int i = 0; i < m; i++) {
            count[i] %= 3;
        }
        for (int i = 0; i < m; i++) {
            number <<= 1;
            number |= count[31 - i];
        }
        return number;
//        int[] counts = new int[32];
//        for(int num : nums) {
//            for(int j = 0; j < 32; j++) {
//                counts[j] += num & 1;
//                num >>>= 1;
//            }
//        }
//        int res = 0, m = 3;
//        for(int i = 0; i < 32; i++) {
//            res <<= 1;
//            res |= counts[31 - i] % m;
//        }
//        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.singleNumber(new int[]{3, 4, 3, 3});
    }
}
