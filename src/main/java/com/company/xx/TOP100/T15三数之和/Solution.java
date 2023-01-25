package com.company.xx.TOP100.T15三数之和;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int target = 0 - nums[second] - nums[first];
                while (third > second) {
                    if (nums[third] == target) {
                        res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                        break;
                    }
                    if (nums[third] < target) {
                        break;
                    }
                    third--;
                }
            }
        }
        return res;
    }
}
