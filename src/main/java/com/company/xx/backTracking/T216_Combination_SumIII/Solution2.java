package com.company.xx.backTracking.T216_Combination_SumIII;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return res;
    }

//    /**
//     * @param k 代表还需要选k个数字
//     * @param n 剩余的总和
//     * @param begin begin~9是选择数的范围
//     */
//    public void dfs(int k, int n, int begin) {
//        if (n == 0 && k == 0) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        if (n <= 0 || k <= 0) {
//            return;
//        }
//        // k <= 9 - i + 1 剩余的数不够选了，直接剪枝
//        for (int i = begin; k <= 9 - i + 1; i++) {
//            path.add(i);
//            dfs(k - 1, n - i, i + 1);
//            path.remove(path.size() - 1);
//        }
//    }

    /**
     * @param k 代表还需要选k个数字
     * @param n 剩余的总和
     * @param i 遍历的索引
     */
    public void dfs(int k, int n, int i) {
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (k <= 0 || n <= 0 || 9 - i + 1 < k) {
            return;
        }
        // 不选
        dfs(k, n, i + 1);
        // 选
        path.add(i);
        dfs(k - 1, n - i, i + 1);
        path.remove(path.size() - 1);
    }


    public static void main(String[] args) {
        new Solution2().combinationSum3(3, 7);
    }
}
