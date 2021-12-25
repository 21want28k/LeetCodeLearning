package com.company.xx.binaryTree.T101_Symmetric_Tree;

import com.company.xx.binaryTree.TreeNode;

import java.util.*;

public class Solution {
    public static boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null) {
            return false;
        }
        if (right == null && left != null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        // 只能是值相等的时候了
        boolean isSymmetricLeft = check(left.left, right.right);
        boolean isSymmetricRight = check(left.right, right.left);

        return isSymmetricLeft && isSymmetricRight;
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null && right != null) {
                return false;
            }
            if (left != null && right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric2(root));
    }
}