package com.company.xx.binaryTree.T236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return null;
        }
//        if ((left == p && right == q) || (left == q && right ==p) || (left == p && root == q) || (right == ))
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.lowestCommonAncestor(TreeUtils.arraysToTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), new TreeNode(1)));
        TreeNode root = TreeUtils.arraysToTree(new Integer[]{1, 2});
        System.out.println(s.lowestCommonAncestor(root, new TreeNode(1), new TreeNode(2)));
    }
}