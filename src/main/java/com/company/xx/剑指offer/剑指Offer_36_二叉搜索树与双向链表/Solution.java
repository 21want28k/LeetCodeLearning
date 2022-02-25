package com.company.xx.剑指offer.剑指Offer_36_二叉搜索树与双向链表;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
    TreeNode pre, head;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            // build successor
            pre.right = cur;
        }
        // build precursor
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    public static void main(String[] args) {
        Integer[] values = {4, 2, 5, 1, 3};
        TreeNode root = TreeUtils.constructTree(values);
        new Solution().treeToDoublyList(root);
    }
}
