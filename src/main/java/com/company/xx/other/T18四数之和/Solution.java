package com.company.xx.other.T18四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                for (int third = second + 1; third < n; third++) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }
                    int fourth = n - 1;
                    long t = (long)target - nums[first] - nums[second] - nums[third];
                    while (fourth > third) {
                        if (nums[fourth] == t) {
                            res.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                            break;
                        }
                        if (nums[fourth] > t) {
                            fourth--;
                            continue;
                        }
                        if (nums[fourth] < t) {
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        new Solution().fourSum(nums,-294967296);
    }
}
