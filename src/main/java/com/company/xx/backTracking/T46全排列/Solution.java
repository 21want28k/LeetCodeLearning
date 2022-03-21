package com.company.xx.backTracking.T46全排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        n = nums.length;
        used = new boolean[n];
        recursion(0, nums);
        return res;
    }


    public void recursion(int index, int[] nums) {
        if (index == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;

            recursion(index + 1, nums);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new Solution().permute(nums));
    }
}
