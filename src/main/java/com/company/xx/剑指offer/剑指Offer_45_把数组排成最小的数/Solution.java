package com.company.xx.剑指offer.剑指Offer_45_把数组排成最小的数;

import java.util.Arrays;

public class Solution {
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] numsStrs = new String[n];
        for (int i = 0; i < n; i++) {
            numsStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStrs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder builder = new StringBuilder();
        for (String str : numsStrs) {
            builder.append(str);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(new Solution().minNumber(nums));
    }
}
