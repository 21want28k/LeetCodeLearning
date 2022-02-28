package com.company.xx.剑指offer.剑指Offer_55_I_二叉树的深度;

import com.company.xx.binaryTree.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
