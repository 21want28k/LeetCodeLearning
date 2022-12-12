package com.company.xx.binaryTree.T700_Search_in_a_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;

public class Solution2 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return root;
    }
}
