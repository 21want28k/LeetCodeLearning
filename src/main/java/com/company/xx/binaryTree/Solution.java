package com.company.xx.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traverse(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode traverse(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        int rootValue = preorder[preorderLeft];
        int rootIndex = map.get(rootValue);
        int leftSubtreeLength = rootIndex - inorderLeft;
        TreeNode root = new TreeNode(rootValue);
        root.left = traverse(preorder, inorder, preorderLeft + 1, preorderLeft + leftSubtreeLength, inorderLeft, rootIndex - 1);
        root.right = traverse(preorder, inorder, preorderLeft + leftSubtreeLength + 1, preorderRight, rootIndex + 1, inorderRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2, 3};
        int[] inorder = new int[]{2, 1, 3};
        Solution s = new Solution();
        TreeNode root = s.buildTree(preorder, inorder);
    }
}
