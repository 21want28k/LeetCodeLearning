package com.company.xx.binaryTree.T235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val >= p.val && root.val <= q.val || root.val <= p.val && root.val >= q.val) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < q.val && root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode rot = TreeUtils.constructTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        new Solution2().lowestCommonAncestor(rot, new TreeNode(2), new TreeNode(4));
    }
}
