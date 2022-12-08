package com.company.xx.binaryTree.T105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import com.company.xx.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int preorderL, int preorderR, int inorderL, int inorderR) {
        if (preorderL > preorderR) {
            return null;
        }
        int rootV = preorder[preorderL];
        int index = map.get(rootV);
        TreeNode root = new TreeNode(rootV);
        int leftNumber = index - inorderL;
        root.left = dfs(preorder, inorder, preorderL + 1, preorderL + leftNumber, inorderL, index - 1);
        root.right = dfs(preorder, inorder, preorderL + leftNumber + 1, preorderR, index + 1, inorderR);
        return root;
    }
}
