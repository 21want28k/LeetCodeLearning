package com.company.xx.binaryTree.T98_Validate_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;

import java.util.Stack;

public class Solution {

    public TreeNode pre = null;

    /**
     * 对二叉搜索树的概念没有搞清楚，二叉搜索树，是所有的左节点都小于根，所有的右节点都大于根
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if ((root.left == null && root.right.val > root.val) || (root.right == null && root.left.val < root.val)) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        if (root.left.val >= root.val || root.right.val <= root.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST2(root.left);
        if (pre != null) {
            if (root.val <= pre.val) {
                return false;
            }
        }

        pre = root;
        boolean right = isValidBST2(root.right);
        return left && right;
    }

    public boolean isValidBST3(TreeNode root) {
        return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    /**
     * @param root  节点
     * @param lower 左开区间
     * @param upper 右开区间
     * @return 是否是二叉搜索树
     */
    public boolean traverse(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return traverse(root.left, lower, root.val) && traverse(root.right, root.val, upper);
    }

    public boolean isValidBST4(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre == null) {
                    pre = cur;
                } else {
                    if (pre.val >= cur.val) {
                        return false;
                    } else {
                        pre = cur;
                    }
                }
                cur = cur.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
        Solution s = new Solution();
        System.out.println(s.isValidBST4(root));
    }
}
