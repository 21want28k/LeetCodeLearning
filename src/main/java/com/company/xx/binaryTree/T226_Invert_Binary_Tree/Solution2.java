package com.company.xx.binaryTree.T226_Invert_Binary_Tree;

import com.company.xx.binaryTree.TreeNode;

import java.util.Stack;

public class Solution2 {
    /**
     * 先序递归遍历
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 后序递归遍历
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//        root.left = right;
//        root.right = left;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            cur.right = left;
            cur.left = right;
            cur = cur.right;
        }
        return root;
    }
}
