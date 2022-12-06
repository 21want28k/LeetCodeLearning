package com.company.xx.binaryTree.T257_Binary_Tree_Paths;

import com.company.xx.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        dfs(root, "", res);
        return res;
    }

    public void dfs(TreeNode root, String s, List<String> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            s += root.val;
            res.add(s);
            return;
        }

        s = s + root.val + "->";
        dfs(root.left, s, res);
        dfs(root.right, s, res);
    }
}
