package com.company.xx.剑指offer.剑指Offer_26_树的子结构;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;
import com.company.xx.剑指offer.ListNodeUtil;

public class Solution {
    boolean result;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        dfs(A, B);
        return result;
    }

    public void dfs(TreeNode A, TreeNode B) {
        if (A == null) {
            return;
        }
        if (A.val == B.val) {
            result = judge(A, B);
        }
        if (result == true) {
            return;
        }
        dfs(A.left, B);
        dfs(A.right, B);
    }

    public boolean judge(TreeNode A, TreeNode B) {
        if (A != null && B == null) {
            return true;
        }
        if (A == null && B != null) {
            return false;
        }
        if (A != null && B != null && A.val != B.val) {
            return false;
        }
        if (A == null && B == null) {
            return true;
        }
        return judge(A.left, B.left) && judge(A.right, B.right);
    }

    public static void main(String[] args) {
        Integer[] a = {3, 4, 5, 1, 2};
        Integer[] b = {4, 1};
        TreeNode A = TreeUtils.arraysToTree(a);
        TreeNode B = TreeUtils.arraysToTree(b);
        Solution s = new Solution();
        System.out.println(s.isSubStructure(A, B));
    }
}
