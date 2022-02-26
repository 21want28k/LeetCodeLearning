package com.company.xx.剑指offer.剑指Offer_61_扑克牌中的顺子;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isStraight(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (set.contains(nums[i])) {
                return false;
            } else {
                set.add(nums[i]);
            }
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max - min + 1 <= n;
    }

    public boolean isStraight2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (i + 1 < n && nums[i + 1] == nums[i]) {
                return false;
            }
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max - min + 1 <= n;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2, 5};
        Solution s = new Solution();
        System.out.println(s.isStraight(nums));
    }
}