package com.company.xx.backTracking.T39_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return result;
    }

    public void backTrack(int[] candidates, int target, int begin) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                continue;
            }
            path.addLast(candidates[i]);
            backTrack(candidates, target - candidates[i], i);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 5, 1};
        int target = 3;
        Solution s = new Solution();
        s.combinationSum(candidates, target);
    }
}
