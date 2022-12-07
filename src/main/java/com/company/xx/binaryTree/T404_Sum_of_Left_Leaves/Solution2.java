package com.company.xx.binaryTree.T404_Sum_of_Left_Leaves;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution2 {
    int sum;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
        }
        dfs(root.left);
        dfs(root.right);
    }

        public int sumOfLeftLeaves2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left != null && root.left.left == null && root.left.right == null) {
                return root.left.val + sumOfLeftLeaves2(root.right);
            }
            return sumOfLeftLeaves2(root.left) + sumOfLeftLeaves2(root.right);
        }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree(new Integer[]{-9, -3, 2, null, 4, 4, 0, -6, null, -5});
        new Solution2().sumOfLeftLeaves(root);
    }
}
