package com.company.xx.binaryTree.T235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > q.val && root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < q.val && root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeUtils.arraysToTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(5);
        System.out.println(s.lowestCommonAncestor(root, p, q));
    }
}
