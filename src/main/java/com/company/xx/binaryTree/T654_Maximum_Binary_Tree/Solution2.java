package com.company.xx.binaryTree.T654_Maximum_Binary_Tree;

import com.company.xx.binaryTree.TreeNode;

public class Solution2 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int maxIndex = getMax(nums, l, r);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = dfs(nums, l, maxIndex - 1);
        root.right = dfs(nums, maxIndex + 1, r);
        return root;
    }

    public int getMax(int[] nums, int l, int r) {
        int index = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }
}
