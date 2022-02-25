package com.company.xx.剑指offer.剑指Offer_27_二叉树的镜像;

import com.company.xx.binaryTree.TreeNode;

public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}