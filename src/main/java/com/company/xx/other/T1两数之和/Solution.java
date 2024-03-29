package com.company.xx.other.T1两数之和;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[]{i, index};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
