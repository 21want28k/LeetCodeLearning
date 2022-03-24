package com.company.xx.binaryTree.T114二叉树展开为链表;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        if (root == null)
            return;
        while (cur != null) {
            TreeNode p = cur.left;
            if (p != null) {
                while (p.right != null) {
                    p = p.right;
                }
                p.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        Integer[] values = {1,null,2,3};
        TreeNode root = TreeUtils.constructTree(values);
        new Solution().flatten(root);
    }
}
