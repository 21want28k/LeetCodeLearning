package com.company.xx.other.T15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, 0);
        return res;
    }

    public void dfs(int[] nums, int target, int begin) {
        if (path.size() == 3) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (begin == nums.length) {
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            if (3 - path.size() > nums.length - i) {
                return;
            }
            if (i < nums.length - 1 && nums[i] + (2 - path.size()) * nums[i + 1] > target) {
                return;
            }
            if (i < nums.length - 1 && nums[i] + (2 - path.size()) * nums[nums.length - 1] < target) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, target - nums[i], i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            for (int second = first + 1; second < n; second++) {
                // 防止重复 second > first + 1，是因为避免second==first的时候，比如[...,first=1,second=1,...]
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                // 算出第三个要找的数
                int thirdTarget = 0-nums[first]- nums[second];
                // 第三个数必须在第二个数右边
                while (third > second) {
                    if (nums[third] > thirdTarget) {
                        third--;
                        continue;
                    }
                    // 找到了目标
                    if (nums[third] == thirdTarget) {
                        List<Integer> one = new ArrayList<>();
                        one.add(nums[first]);
                        one.add(nums[second]);
                        one.add(nums[third]);
                        res.add(one);
                        break;
                    }
                    // 没找到。
                    if (nums[third] < thirdTarget) {
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        new Solution().threeSum(nums);
    }
}
