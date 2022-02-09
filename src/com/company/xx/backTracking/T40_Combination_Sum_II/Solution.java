package com.company.xx.backTracking.T40_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> result = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        backTrack(0, candidates, target);
        return result;
    }

    public void backTrack(int begin, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            backTrack(i + 1, candidates, target - candidates[i]);
            path.removeLast();
        }
    }
}