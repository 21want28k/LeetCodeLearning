package com.company.xx.剑指offer.剑指offer_面试题32_I_从上到下打印二叉树;

import com.company.xx.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pop();
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
                path.add(cur.val);
            }
        }
        int[] result = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            result[i] = path.get(i);
        }
        return result;
    }
}