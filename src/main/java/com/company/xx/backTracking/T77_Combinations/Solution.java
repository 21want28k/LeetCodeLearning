package com.company.xx.backTracking.T77_Combinations;

import java.util.*;

public class Solution {
    Deque<Integer> path = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return result;
    }

    public void dfs(int n, int k, int begin) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n + 1 - (k - path.size()); i++) {
            path.offerLast(i);
            dfs(n, k, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        dfs2(n, k, 1);
        return result;
    }

    public void dfs2(int n, int k, int begin) {
        if (k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 剪枝
        if (n - begin + 1 < k) {
            return;
        }

        dfs2(n, k, begin + 1);

        path.addLast(begin);
        dfs2(n, k-1, begin + 1);
        path.removeLast();
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Solution s = new Solution();
        s.combine2(n, k);
    }
}
