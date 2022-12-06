package com.company.xx.binaryTree.T110_Balanced_Binary_Tree;

import com.company.xx.binaryTree.TreeNode;

public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }


    public boolean isBalanced2(TreeNode root) {
        return check(root) != -1;
    }

    public int check(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = check(root.left);
        if (left == -1) {
            return -1;
        }
        int right = check(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
