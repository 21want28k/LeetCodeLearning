package com.company.xx.backTracking.T77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> item = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        choose(n, k, 1);
        return res;
    }

    /**
     * @param n
     * @param k
     * @param index 代表n个数字里面的第index个数字，也就是1~n个待选数字里面的索引
     */
    public void choose(int n, int k, int index) {
        if (item.size() == k) {
            res.add(new ArrayList<>(item));
            return;
        }
//        for (int i = index; i <= n; i++) {
//            item.add(i);
//            index++;
//            choose(n, k, index);
//            item.remove(item.size() - 1);
//        }
        // 从index~n开始选择，i是选择的索引，还需要选择k-item.size个数字, n-i+1代表还剩几个数可以选择
        for (int i = index; n - i + 1 >= k - item.size(); i++) {
            item.add(i);
            choose(n, k, i + 1);
            item.remove(item.size() - 1);
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        dfs(n, k, 1);
        return res;
    }

    public void dfs(int n, int k, int index) {
        if (k == 0) {
            res.add(new ArrayList<>(item));
            return;
        }
        if (k > n - index + 1) {
            return;
        }

        // 不选
        dfs(n, k, index + 1);

        // 选
        item.add(index);
        dfs(n, k - 1, index + 1);
        item.remove(item.size() - 1);
    }

    public static void main(String[] args) {
        new Solution2().combine(4, 2);
    }
}
