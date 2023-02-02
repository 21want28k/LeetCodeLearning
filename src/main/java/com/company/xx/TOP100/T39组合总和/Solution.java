package com.company.xx.TOP100.T39组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> one = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        dfs(target, candidates);
        return res;
    }

    public void dfs(int target, int[] candidates) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(one));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            if (one.size() >= 1 && candidates[i] < one.get(one.size() - 1)) {
                continue;
            }
            one.add(candidates[i]);
            dfs(target - candidates[i], candidates);
            one.remove(one.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] c = {2, 3, 5};
        int target = 8;
        new Solution().combinationSum(c, target);
    }
}
