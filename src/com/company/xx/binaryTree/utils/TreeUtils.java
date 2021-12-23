package com.company.xx.binaryTree.utils;

import com.company.xx.binaryTree.TreeNode;

public class TreeUtils {
    /**
     *       1
     *      / \
     *     2   3
     *    / \ / \
     *   4  56  7
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
}
