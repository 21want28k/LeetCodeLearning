package com.company.xx.backTracking.T39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || index == candidates.length) {
            return;
        }

        // 不选
        dfs(candidates, target, index + 1);
        // 选
        path.add(candidates[index]);
        dfs(candidates, target - candidates[index], index);
        path.remove(path.size() - 1);
    }
}
