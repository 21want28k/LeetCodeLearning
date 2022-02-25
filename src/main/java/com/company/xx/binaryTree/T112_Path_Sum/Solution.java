package com.company.xx.binaryTree.T112_Path_Sum;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return pathSum2(root, 0, targetSum);
    }

    public boolean pathSum(TreeNode root, int path, int targetSum) {
        if (root.left == null && root.right != null) {
            path += root.val;
            return pathSum(root.right, path, targetSum);
        }
        if (root.left != null && root.right == null) {
            path += root.val;
            return pathSum(root.left, path, targetSum);
        }
        if (root.left == null && root.right == null) {
            path += root.val;
            return path == targetSum;
        }
        if (root.left != null && root.right != null) {
            path += root.val;
            return pathSum(root.left, path, targetSum) || pathSum(root.right, path, targetSum);
        }
        return false;
    }

    public boolean pathSum2(TreeNode root, int path, int targetSum) {
        if (root == null) {
            return false;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            return path == targetSum;
        }
        return pathSum(root.left, path, targetSum) || pathSum(root.right, path, targetSum);
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }

    public boolean pathSum3(TreeNode root, int path, int targetSum) {
        if (root == null) {
            return false;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            return path == targetSum;
        }
        return pathSum(root.left, path, targetSum) || pathSum(root.right, path, targetSum);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(s.hasPathSum(root, 3));
    }
}
