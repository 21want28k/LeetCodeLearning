package com.company.xx.binaryTree.T530_Minimum_Absolute_Difference_in_BST;

import cn.hutool.core.lang.tree.TreeUtil;
import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;
import sun.invoke.util.VerifyAccess;

import java.util.Arrays;

public class Solution2 {
    private int min = Integer.MAX_VALUE;
    private TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == null) {
            pre = root;
        } else {
            int abs = Math.abs(root.val - pre.val);
            if (abs < min) {
                min = abs;
            }
            pre = root;
        }

        dfs(root.right);
    }

    public static void main(String[] args) {
        Integer[] values = new Integer[]{543, 384, 652, 0, 445, 0, 699};
        Arrays.sort(values);
        TreeNode root = TreeUtils.constructTree(new Integer[]{543, 384, 652, null, 445, null, 699});
        new Solution2().getMinimumDifference(root);
    }
}
