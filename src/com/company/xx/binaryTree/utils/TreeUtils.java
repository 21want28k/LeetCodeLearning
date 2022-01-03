package com.company.xx.binaryTree.utils;

import com.company.xx.binaryTree.TreeNode;

import java.util.Arrays;

public class TreeUtils {
    /**
     * 1
     * / \
     * 2   3
     * / \ / \
     * 4  56  7
     *
     * @return
     */
    public static TreeNode getTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static TreeNode arraysToTree(Integer[] arrays) {
        if (arrays.length == 0) {
            return null;
        }
        return traverse(arrays, 0);
    }

    public static TreeNode traverse(Integer[] arrays, int index) {
        if (index > arrays.length - 1 || arrays[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arrays[index]);
        root.left = traverse(arrays, 2 * index + 1);
        root.right = traverse(arrays, 2 * index + 2);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = arraysToTree(new Integer[]{1, null, 2, null, null, 2});
    }
}
