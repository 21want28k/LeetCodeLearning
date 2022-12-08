package com.company.xx.binaryTree.T617_Merge_Two_Binary_Trees;

import com.company.xx.binaryTree.TreeNode;

public class Solution2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode();
        if (root1 != null && root2 == null) {
            return root1;
        }
        if (root2 != null && root1 == null) {
            return root2;
        }
        root.val += root1.val + root2.val;
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
