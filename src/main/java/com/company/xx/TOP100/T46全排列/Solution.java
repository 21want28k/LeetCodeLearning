package com.company.xx.TOP100.T46全排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> one = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        used = new boolean[n];
        dfs(nums);
        return res;
    }

    public void dfs(int[] nums) {
        if (one.size() == nums.length) {
            res.add(new ArrayList<>(one));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            one.add(nums[i]);
            used[i] = true;
            dfs(nums);
            one.remove(one.size() - 1);
            used[i] = false;
        }
    }
}
