package com.company.xx.binaryTree.T226_Invert_Binary_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        swap(root);
    }

    public static void swap(TreeNode root) {
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        return root;
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public static TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return root;
        }

        swap(root);

        invertTree3(root.left);
        invertTree3(root.right);

        return root;
    }

    public static void main(String[] args) {
        invertTree(TreeUtils.getTree());
    }
}