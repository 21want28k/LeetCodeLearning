package com.company.xx.binaryTree.T700_Search_in_a_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val != val) {
            TreeNode leftResult = searchBST(root.left, val);
            return leftResult == null ? searchBST(root.right, val) : leftResult;
        } else {
            return root;
        }
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return root.val > val ? searchBST2(root.left, val) : searchBST2(root.right, val);
    }
}
