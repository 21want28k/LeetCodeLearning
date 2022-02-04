package com.company.xx.剑指offer.剑指Offer_07_重建二叉树;

import com.company.xx.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return recursion(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public TreeNode recursion(int[] preorder, int pL, int pR, int[] inorder, int iL, int iR) {
        if (pL > pR) {
            return null;
        }
        int rootValue = preorder[pL];
        TreeNode root = new TreeNode(rootValue);
        int i = map.get(rootValue);
        int leftLength = i - iL;
        root.left = recursion(preorder, pL + 1, pL + leftLength, inorder, iL, i);
        root.right = recursion(preorder, pL + leftLength + 1, pR, inorder, i + 1, iR);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2};
        int[] inorder = {2, 1};
        Solution s = new Solution();
        TreeNode root = s.buildTree(preorder, inorder);
    }
}
