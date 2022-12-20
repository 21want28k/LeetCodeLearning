package com.company.xx.backTracking.T40_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     * 这种方法想去除结果里面的重复有点困难，所以不用选/不选这种方法，还用for循环的方法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        choose(candidates, target, 0);
        return res;
    }

    public void choose(int[] candidates, int target, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || begin == candidates.length) {
            return;
        }
        choose(candidates, target, begin + 1);

        path.add(candidates[begin]);
        choose(candidates, target - candidates[begin], begin + 1);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return res;
    }

    public void backTrack(int[] candidates, int target, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length && target >= candidates[i]; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}
