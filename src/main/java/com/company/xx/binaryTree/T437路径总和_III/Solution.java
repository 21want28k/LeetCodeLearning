package com.company.xx.binaryTree.T437路径总和_III;

import com.company.xx.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    Map<Long, Integer> map = new HashMap<>();
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        // 这里就是那个虚拟节点
        map.put(0L, 1);
        dfs(root, 0, targetSum);
        return res;
    }

    public void dfs(TreeNode root, long cur, int targetSum) {
        if (root == null) {
            return;
        }
        cur += root.val;
        res += map.getOrDefault(cur - targetSum, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        dfs(root.left, cur, targetSum);
        dfs(root.right, cur, targetSum);
        // 回溯，至于为什么这么写，你需要基本的回溯常识，这里因为我很明白，所以就不写了，
        // 注意cur为什么不用回溯？因为cur是局部变量，而map是递归过程中公用的
        map.put(cur, map.getOrDefault(cur, 0) - 1);
    }

}
