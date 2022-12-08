package com.company.xx.binaryTree.T106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inorderL, int inorderR, int postorderL, int postorderR) {
        if (inorderL > inorderR) {
            return null;
        }
        int rootV = postorder[postorderR];
        TreeNode root = new TreeNode(rootV);
        int index = map.get(rootV); // 获得在前序遍历中的root节点索引
        int leftNumber = index - inorderL;
        root.left = buildTree(inorder, postorder, inorderL, index - 1, postorderL, postorderL + leftNumber - 1);
        root.right = buildTree(inorder, postorder, index + 1, inorderR, postorderL + leftNumber, postorderR - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        new Solution2().buildTree(inorder, postorder);
    }
}
