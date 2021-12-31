package com.company.xx.binaryTree.T113_Path_Sum_II;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, targetSum, path, result);
        return result;
    }

    public void traverse(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                result.add(new ArrayList<>(path));
            }
//            path.remove(path.size() - 1);
        }
        traverse(root.left, targetSum - root.val, path, result);
        if (root.left != null) {
            path.remove(path.size() - 1);
        }
        traverse(root.right, targetSum - root.val, path, result);
        if (root.right != null) {
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(s.pathSum(root, 3));
    }
}