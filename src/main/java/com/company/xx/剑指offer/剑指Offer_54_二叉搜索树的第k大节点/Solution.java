package com.company.xx.剑指offer.剑指Offer_54_二叉搜索树的第k大节点;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
//    int result;
//
//    public int kthLargest(TreeNode root, int k) {
//        dfs(root, k);
//        return result;
//    }
//
//    public void dfs(TreeNode root, int k) {
//        if (root == null) {
//            return;
//        }
//        dfs(root.right, k);
//        // 已经找到对应的k了，剪枝
//        if (k == 0) {
//            return;
//        }
//        k--;
//        if (k == 0) {
//            result = root.val;
//            return;
//        }
//        dfs(root.left, k);
//    }
    int result, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    public void dfs(TreeNode root) {
        if (root == null || k <= 0) {
            return;
        }
        dfs(root.right);
        // 已经找到对应的k了，剪枝
//        if (k == 0) {
//            return;
//        }
        k--;
        if (k == 0) {
            result = root.val;
            return;
        }
        dfs(root.left);
    }

    public static void main(String[] args) {
        Integer[] values = {3, 1, 4, null, 2};
        TreeNode root = TreeUtils.constructTree(values);
        new Solution().kthLargest(root, 1);
    }
}
