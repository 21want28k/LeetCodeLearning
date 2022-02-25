package com.company.xx.binaryTree.T108_Convert_Sorted_Array_to_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        }
        return traverse(nums, 0, n - 1);
    }

    public TreeNode traverse(int[] nums, int first, int last) {
        if (first > last) {
            return null;
        }
//        int mid = (first + last) / 2;
        int mid = first + ((last - first) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traverse(nums, first, mid - 1);
        root.right = traverse(nums, mid + 1, last);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}