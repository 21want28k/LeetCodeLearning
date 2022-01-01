package com.company.xx.binaryTree.T106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import com.company.xx.binaryTree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Map<Integer, Integer> inorderMap = new HashMap<>();  // inorder[index]:index, get index by value

    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        if (inorder.length == 0 && postorder.length == 0)
        int postLength = postorder.length;
        int inorderLength = inorder.length;

        if (postLength == 0 && inorderLength == 0) {
            return null;
        }

        int rootValue = postorder[postLength - 1];
        TreeNode root = new TreeNode(rootValue);

        int inorderIndex;
        for (int i = 0; i < inorderLength; i++) {
            if (inorder[i] == rootValue) {
                inorderIndex = i;
                int[] leftInorder = Arrays.copyOfRange(inorder, 0, inorderIndex);
                int[] rightInorder = Arrays.copyOfRange(inorder, inorderIndex + 1, inorderLength);
                int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
                int[] rightPostOrder = Arrays.copyOfRange(postorder, leftInorder.length, leftInorder.length + rightInorder.length);
                TreeNode leftRoot = buildTree(leftInorder, leftPostOrder);
                TreeNode rightRoot = buildTree(rightInorder, rightPostOrder);
                root.left = leftRoot;
                root.right = rightRoot;
                break;
            }
        }
        return root;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return traverse(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode traverse(int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postOrderLeft, int postOrderRight) {
        if (inorderLeft > inorderRight) {
            return null;
        }
        int rootValue = postorder[postOrderRight];
        int inorderRootIndex = inorderMap.get(rootValue);
        int leftSubTreeLength = inorderRootIndex - inorderLeft;
        TreeNode root = new TreeNode(rootValue);
        root.left = traverse(inorder, postorder, inorderLeft, inorderRootIndex - 1, postOrderLeft, postOrderLeft + leftSubTreeLength - 1);
        root.right = traverse(inorder, postorder, inorderRootIndex + 1, inorderRight, postOrderLeft + leftSubTreeLength, postOrderRight - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{2, 1, 3};
        int[] postOrder = new int[]{2, 3, 1};
        Solution s = new Solution();
        TreeNode root = s.buildTree2(inorder, postOrder);
    }
}
