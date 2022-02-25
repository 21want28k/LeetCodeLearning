package com.company.xx.binaryTree.T701_Insert_into_a_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        traverse(root, val, null, 0);
        return root;
    }

    public void traverse(TreeNode root, int val, TreeNode father, int leftOrRight) {
        if (root == null) {
            if (leftOrRight == 1) {
                father.left = new TreeNode(val);
            }
            if (leftOrRight == 2) {
                father.right = new TreeNode(val);
            }
            return;
        }
        if (root.val > val) {
            traverse(root.left, val, root, 1);
        }
        if (root.val < val) {
            traverse(root.right, val, root, 2);
        }
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST2(root.right, val);
        }
        if (val < root.val) {
            root.left = insertIntoBST2(root.left, val);
        }
        return root;
    }

    public TreeNode insertIntoBST3(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (cur != null) {
            if (val < cur.val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                }
                cur = cur.left;
            }
            if (val > cur.val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.arraysToTree(new Integer[]{4, 2, 7, 1, 3});
        Solution s = new Solution();
        s.insertIntoBST(root, 5);
    }
}
