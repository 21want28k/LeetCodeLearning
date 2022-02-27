package com.company.xx.剑指offer.剑指Offer_33_二叉搜索树的后序遍历序列;

public class Solution {
    int end;

    public boolean verifyPostorder(int[] postorder) {
        end = postorder.length - 1;
        build(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return end < 0;
    }

    public void build(int[] postorder, int min, int max) {
        if (end < 0) {
            return;
        }
        int root = postorder[end];
        if (root >= max || root <= min) {
            return;
        }
        end--;
        build(postorder, root, max); // build left subtree
        build(postorder, min, root); // build right subtree
    }

    public static void main(String[] args) {
        int[] postorder = {4, 8, 6, 12, 16, 14, 10};
        new Solution().verifyPostorder(postorder);
    }
}