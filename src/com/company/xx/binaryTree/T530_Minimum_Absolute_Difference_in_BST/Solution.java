package com.company.xx.binaryTree.T530_Minimum_Absolute_Difference_in_BST;

import com.company.xx.binaryTree.TreeNode;

public class Solution {
    TreeNode pre = null;
    int minDifference = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return minDifference;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (pre != null) {
//            minDifference = Math.min(Math.abs(pre.val - root.val), minDifference); optimize
            minDifference = Math.min(root.val - pre.val, minDifference);
        }
        pre = root;
        traverse(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(543);
        root.left = new TreeNode(384);
        root.right = new TreeNode(652);
        root.left.right = new TreeNode(445);
        root.right.right = new TreeNode(699);
        Solution s = new Solution();
        System.out.println(s.getMinimumDifference(root));
    }
}
