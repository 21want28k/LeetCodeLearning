package com.company.xx.backTracking.T46全排列;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] visited = new int[21];

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return res;
    }

    public void dfs(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[nums[i] + 10] == 1) {
                continue;
            }
            visited[nums[i] + 10] = 1;
            path.add(nums[i]);
            dfs(nums);
            path.remove(path.size() - 1);
            visited[nums[i] + 10] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution2().permute(nums);
    }
}
