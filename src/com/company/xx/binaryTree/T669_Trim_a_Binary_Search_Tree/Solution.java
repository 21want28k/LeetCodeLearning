package com.company.xx.binaryTree.T669_Trim_a_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
    //    public TreeNode trimBST(TreeNode root, int low, int high) {
//        if (root == null) {
//            return null;
//        }
//        if (!judge(root.val, low, high)) {
//            if (root.left == null && root.right == null) {
//                return null;
//            }
//            if (root.left != null && root.right == null) {
//                TreeNode leftRightest = findLeftRightest(root);
//                root.val = leftRightest.val;
//                root.left = trimBST(leftRightest, low, high);
//            }
//            if ((root.left == null && root.right != null)
//                    || (root.left != null && root.right != null)) {
//                TreeNode rightLeftest = findRightLeftest(root);
//                root.val = rightLeftest.val;
//                root.left = trimBST(rightLeftest, low, high);
//            }
//        } else {
//            root.left = trimBST(root.left, low, high);
//            root.right = trimBST(root.right, low, high);
//        }
//        return root;
//    }
//
//    public boolean judge(int val, int low, int high) {
//        return (val >= low) && (val <= high);
//    }
//
//    public TreeNode findLeftRightest(TreeNode root) {
//        root = root.left;
//        while (root.right != null) {
//            root = root.right;
//        }
//        return root;
//    }
//
//    public TreeNode findRightLeftest(TreeNode root) {
//        root = root.right;
//        while (root.left != null) {
//            root = root.left;
//        }
//        return root;
//    }
//
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            root = root.right;
            return trimBST(root, low, high);
        }
        if (root.val > high) {
            root = root.left;
            return trimBST(root, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node = TreeUtils.arraysToTree(new Integer[]{3, 0, 4, null, 2, null, null, null, null, 1});
        TreeNode root = s.trimBST(node, 1, 3);
    }
}
