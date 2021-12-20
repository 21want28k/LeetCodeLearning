package com.company.xx.two_branch_tree.T102_Binary_Tree_Level_Order_Traversal;

import com.company.xx.two_branch_tree.TreeNode;

import java.util.*;

public class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                levelNodes.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            result.add(levelNodes);
        }
        return result;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        levelOrder(root);
        HashMap<String,String> map = new HashMap<>();
        map.put("a","b");
//        List<Integer> list = new ArrayList<>();
    }
}