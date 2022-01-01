package com.company.xx.binaryTree.T654_Maximum_Binary_Tree;

import com.company.xx.binaryTree.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traverse(nums, 0, nums.length - 1);
    }

    public TreeNode traverse(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int max = nums[left];
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        int rootValue = max;
        TreeNode root = new TreeNode(rootValue);
        root.left = traverse(nums, left, index - 1);
        root.right = traverse(nums, index + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        Solution s = new Solution();
        TreeNode root = s.constructMaximumBinaryTree(nums);
    }
}
