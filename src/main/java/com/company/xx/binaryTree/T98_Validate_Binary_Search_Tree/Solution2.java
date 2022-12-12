package com.company.xx.binaryTree.T98_Validate_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /**
     * 错误代码，要注意二叉树的条件，某一个节点上的值要比左子树上面所有的节点都大才行，这里只能保证比左右大。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.left.val > root.val) {
                return false;
            }

        }
        if (root.right != null) {
            if (root.right.val < root.val) {
                return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidBST2(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        dfs(root, values);
        return checkValues(values);
    }

    public void dfs(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        dfs(root.left, values);
        values.add(root.val);
        dfs(root.right, values);
    }

    public boolean checkValues(List<Integer> values) {
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) > values.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    TreeNode pre = null;

    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST3(root.left);
        if (left == false) {
            return false;
        }
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;
        boolean right = isValidBST3(root.right);
        if (right == false) {
            return false;
        }
        return true;
    }
    public boolean isValidBST4(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST4(root.left);
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;
        boolean right = isValidBST4(root.right);
        return left && right;
    }


    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree(new Integer[]{5, 4, 7, 1, 3, 8, 9});
        new Solution2().isValidBST4(root);
    }
}
