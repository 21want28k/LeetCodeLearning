package com.company.xx.binaryTree.T113_Path_Sum_II;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        check(root, targetSum, path);
        return res;
    }

    public void check(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                res.add(new ArrayList<>(path));
            }
        }
        check(root.left, targetSum, path);
        check(root.right, targetSum, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        new Solution2().pathSum(root, 22);
    }
}
