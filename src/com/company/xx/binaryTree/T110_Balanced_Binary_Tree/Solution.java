package com.company.xx.binaryTree.T110_Balanced_Binary_Tree;


import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {

    public static int count = 0;

    /********************************************复杂度O(N)******************************************************/

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = height(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        return Math.abs(leftHeight - rightHeight) <= 1 ? Math.max(leftHeight, rightHeight) + 1 : -1;
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if ((leftHeight == -1 || rightHeight == -1) || Math.abs(leftHeight - rightHeight) <= 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /********************************************复杂度O(N^2)******************************************************/

    public int height3(TreeNode root) {
        count++;
        if (root == null) {
            return 0;
        }
        int leftHeight = height3(root.left);
        int rightHeight = height3(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced3(TreeNode root) {
        count++;
        if (root == null) {
            return true;
        }
        if (Math.abs(height3(root.left) - height3(root.right)) <= 1 && isBalanced3(root.left) && isBalanced3(root.right)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBalanced4(TreeNode root) {
        count++;
        if (root == null) {
            return true;
        }
        if (Math.abs(height3(root.left) - height3(root.right)) <= 1) {
            return isBalanced4(root.left) && isBalanced4(root.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        Solution solution = new Solution();
//        System.out.println(solution.isBalanced3(TreeUtils.getTree()));
        System.out.println(solution.isBalanced3(root));
        System.out.println(count);
    }
}
