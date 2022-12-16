package com.company.xx.binaryTree.T538_Convert_BST_to_Greater_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution2 {

    TreeNode pre = new TreeNode(0);
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val+= pre.val;
        pre = root;
        convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        new Solution2().convertBST(root);
    }
}
