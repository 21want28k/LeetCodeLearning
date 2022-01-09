package com.company.xx.剑指offer.剑指_Offer_03_数组中重复的数字;

import java.util.HashMap;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        int repeat = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) != null) {
                repeat = num;
            } else {
                map.put(num, 1);
            }
        }
        return repeat;
    }

    public static int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        findRepeatNumber2(nums);
    }
}
