package com.company.xx.backTracking.T216_Combination_SumIII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private LinkedList<Integer> path;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.path = new LinkedList<>();
        dfs(k, n, 1, 9);
        return result;
    }

    public void dfs(int k, int sum, int begin, int n) {
        // 选够了k个数，并且这k个数的和是sum就是我们想要的目标
        if (sum == 0 && path.size() == k) {
            // 不能直接add path，后续操作会修改path的值，会影响前面的结果
            result.add(new ArrayList<>(path));
            return;
        }
        // n-i+1是待选的数>=选k-path.size()个数字，并且剩余值sum>i的值才能选，比如[i=4..9]选sum=3就没有必要
        for (int i = begin; i <= sum && k - path.size() <= n - i + 1; i++) {
            path.addLast(i);
            dfs(k, sum - i, i + 1, n);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3_2(int k, int n) {
        this.path = new LinkedList<>();
        dfs2(k, n, 1, 9);
        return result;
    }

    public void dfs2(int k, int sum, int begin, int n) {
        if (sum == 0 && path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 剪枝，这里是||的条件，不是&&，这个问题坑了我很久zz
        if (sum < begin || n - begin + 1 < k - path.size()) {
            return;
        }
        dfs2(k, sum, begin + 1, n);
        path.addLast(begin);
        dfs2(k, sum - begin, begin + 1, n);
        path.removeLast();
    }

    public static void main(String[] args) {
        int k = 3, n = 9;
        Solution s = new Solution();
        s.combinationSum3_2(k, n);
    }
}
