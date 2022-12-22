package com.company.xx.backTracking.T47全排列2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] used = new int[21];

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums);
        return res;
    }

    public void dfs(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        int[] visited = new int[21];
        for (int i = 0; i < nums.length; i++) {
            if (visited[nums[i]] == 1) { // 这一层使用过，退出
                continue;
            }
            if (used[i] == 1) { // 这一个分支已经用过了
                continue;
            }
            visited[nums[i]] = 1;
            used[i] = 1;
            path.add(nums[i]);
            dfs(nums);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        new Solution().permuteUnique(nums);
    }
}
