package com.company.xx.剑指offer.剑指Offer_28_对称的二叉树;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return traverse(root.left, root.right);
    }

    public boolean traverse(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val == right.val) {
            return traverse(left.left, right.right) && traverse(left.right, right.left);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Integer[] root = {1, 2, 2, null, 3, null, 3};
        Solution s = new Solution();
        System.out.println(s.isSymmetric(TreeUtils.arraysToTree(root)));
    }
}
