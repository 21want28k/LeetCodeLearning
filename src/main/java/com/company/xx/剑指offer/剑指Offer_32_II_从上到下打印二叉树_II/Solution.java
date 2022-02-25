package com.company.xx.剑指offer.剑指Offer_32_II_从上到下打印二叉树_II;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    LinkedList<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pop();
                path.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            result.add(path);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] treeValues = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeUtils.arraysToTree(treeValues);
        System.out.println(new Solution().levelOrder(root));
    }
}
