package com.company.xx.backTracking.T78子集;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int begin) {
        if (begin == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(nums, begin + 1);

        path.add(nums[begin]);
        dfs(nums, begin + 1);
        path.remove(path.size() - 1);
    }
}
