package com.company.xx.binaryTree.T236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import com.company.xx.binaryTree.TreeNode;

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        if (right != null) {
            return right;
        }
        return left;
    }

}
