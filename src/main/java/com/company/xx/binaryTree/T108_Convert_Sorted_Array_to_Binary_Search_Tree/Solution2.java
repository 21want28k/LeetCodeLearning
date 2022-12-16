package com.company.xx.binaryTree.T108_Convert_Sorted_Array_to_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;

public class Solution2 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int position = low + ((high - low) >> 1);
        TreeNode root = new TreeNode(nums[position]);
        root.left = build(nums, low, position - 1);
        root.right = build(nums, position + 1, high);
        return root;
    }
}
