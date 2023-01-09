package com.company.xx.DP.T337打家劫舍_III;

import com.company.xx.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (map.get(root) != null) {
            return map.get(root);
        }
        // 偷
        int value1 = root.val;
        if (root.left != null) {
            value1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            value1 += rob(root.right.left) + rob(root.right.right);
        }

        // 不偷
        int value2 = rob(root.left) + rob(root.right);

        int max = Math.max(value1, value2);
        map.put(root, max);
        return max;
    }

    public int rob2(TreeNode root) {
        int[] dp = dp(root);
        return Math.max(dp[0], dp[1]);
    }

    public int[] dp(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) {
            return dp;
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);

        // 当前节点偷
        dp[0] = root.val + left[1] + right[1];
        // 当前节点不偷，四种情况，左偷，右偷； 左偷，右不偷；左不偷，右不偷；左不偷，右不偷；
        dp[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return dp;
    }
}
