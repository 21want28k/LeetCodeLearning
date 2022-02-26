package com.company.xx.binaryTree.T404_Sum_of_Left_Leaves;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
//        return collect(root.left, true, 0) + collect(root.right, false, 0);
        return collect2(root, 0);
    }

    public int collect(TreeNode root, boolean leftOrRight, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && leftOrRight == true) {
            sum += root.val;
            return sum;
        }
        return collect(root.left, true, sum) + collect(root.right, false, sum);
    }

    public int collect2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = root.left.val + collect2(root.right, sum);
            return sum;
        }
        return collect2(root.left, sum) + collect2(root.right, sum);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sumOfLeftLeaves(TreeUtils.getTree()));
    }
}