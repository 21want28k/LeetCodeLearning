package com.company.xx.binaryTree.T669_Trim_a_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution2 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val >= low && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        if (root.val < low) {
            root = trimBST(root.right,low,high); // 左子树可以不要了，因为左子树都不符合要求，将重构好的右子树进行返回。
        } else if (root.val > high) {
            root = trimBST(root.left, low, high);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree(new Integer[]{3, 1, 4, null, 2});
        new Solution2().trimBST(root, 1, 2);
    }
}
