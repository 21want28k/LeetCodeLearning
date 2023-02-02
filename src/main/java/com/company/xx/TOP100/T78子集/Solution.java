package com.company.xx.TOP100.T78子集;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> one = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            res.add(new ArrayList<>(one));
            return;
        }
        dfs(nums, startIndex + 1);
        one.add(nums[startIndex]);
        dfs(nums, startIndex + 1);
        one.remove(one.size() - 1);
    }
}
