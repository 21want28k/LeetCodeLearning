package com.company.xx.DP.T337打家劫舍_III;

import com.company.xx.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 偷
    Map<TreeNode, Integer> f = new HashMap<>();
    // 不偷
    Map<TreeNode, Integer> g = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) +
                Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }


    public int rob2(TreeNode root) {
        int[] res = dfs2(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs2(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] res = new int[2];

        int[] left = dfs2(node.left);
        int[] right = dfs2(node.right);
        res[0] = node.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}