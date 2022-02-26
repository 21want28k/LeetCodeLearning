package com.company.xx.binaryTree.T617_Merge_Two_Binary_Trees;

import com.company.xx.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        int root1Value = root1 == null ? 0 : root1.val;
        int root2Value = root2 == null ? 0 : root2.val;

        TreeNode node = new TreeNode(root1Value + root2Value);
        if (root1 == null) {
            node.left = mergeTrees(null, root2.left);
            node.right = mergeTrees(null, root2.right);
        }
        if (root2 == null) {
            node.left = mergeTrees(root1.left, null);
            node.right = mergeTrees(root1.right, null);
        }
        if (root1 != null && root2 != null) {
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
        }
        return node;
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        Solution s = new Solution();
        TreeNode root = s.mergeTrees(root1, root2);
    }
}