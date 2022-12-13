package com.company.xx.binaryTree.T701_Insert_into_a_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;

public class Solution2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        return dfs(root, val);
    }

    public TreeNode dfs(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.val > val) {
            root.left = new TreeNode(val);
        }
        if (root.right == null && root.val < val) {
            root.right = new TreeNode(val);
        }
        if (root.val > val) {
            insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            insertIntoBST(root.right, val);
        }
        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST2(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST2(root.left, val);
        }
        return root;
    }
}
