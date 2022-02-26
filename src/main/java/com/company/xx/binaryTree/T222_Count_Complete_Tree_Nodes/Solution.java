package com.company.xx.binaryTree.T222_Count_Complete_Tree_Nodes;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0;
        int rightDepth = 0;
        while (left != null) {
            leftDepth++;
            left = left.left;
        }
        while (right != null) {
            rightDepth++;
            right = right.right;
        }
        if (leftDepth == rightDepth) {
            return (1 << leftDepth + 1) - 1; // 2^k - 1 perfect tree node formula <=> 1*2^(leftDepth+1) -1
        }

        // not perfect tree, continue recursion
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        System.out.println(countNodes(TreeUtils.getTree()));
    }
}
