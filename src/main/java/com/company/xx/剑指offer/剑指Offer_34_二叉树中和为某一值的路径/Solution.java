package com.company.xx.剑指offer.剑指Offer_34_二叉树中和为某一值的路径;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return result;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target - root.val;
        if (target == 0) {
            result.add(new ArrayList<>(path));
//            return;
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Integer[] values = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = TreeUtils.constructTree(values);
        int targetSum = 22;
        new Solution().pathSum(root, targetSum);
    }
}
