package com.company.xx.backTracking.T78子集;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return res;
        }

        recursion(nums, 0);
        return res;
    }

    public void recursion(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        recursion(nums, index + 1);

        path.add(nums[index]);
        recursion(nums, index + 1);
        path.remove(path.size() - 1);
    }
}
