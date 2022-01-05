package com.company.xx.binaryTree.T450_Delete_Node_in_a_BST;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        if (key == root.val) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left != null && root.right == null) {
                TreeNode leftRightest = findLeftRightest(root);
                root.val = leftRightest.val;
                root.left = deleteNode(root.left, leftRightest.val);
            }
            if ((root.right != null && root.left == null)
                    || (root.right != null && root.left != null)) {
                TreeNode rightLeftest = findRightLeftest(root);
                root.val = rightLeftest.val;
                root.right = deleteNode(root.right, rightLeftest.val);
            }
        }
        return root;
    }

    public TreeNode findLeftRightest(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public TreeNode findRightLeftest(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.arraysToTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        Solution s = new Solution();
        s.deleteNode(root, 3);
//        System.out.println(s.findRightLeftest(root));
    }
}
