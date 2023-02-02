package com.company.xx.TOP100.T40组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> one = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int startIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(one));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
//            if (one.size() >= 1 && candidates[i] < one.get(one.size()-1)){
//                return;
//            }
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                return;
            }
            one.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            one.remove(one.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] c = {10, 1, 2, 7, 6, 1, 5};
        new Solution().combinationSum2(c, 8);
    }
}
