package com.company.xx.TOP100.T1两数之和;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            Integer integer = map.get(target - nums[i]);
            if (integer != null) {
                res[0] = i;
                res[1] = integer;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
