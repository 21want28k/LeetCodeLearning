package com.company.xx.binaryTree.T515_Find_Largest_Value_in_Each_Tree_Row;

import com.company.xx.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValues = new ArrayList<>();

        if (root == null) {
            return largestValues;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                max = Math.max(max, node.val);
            }
            largestValues.add(max);
        }
        return largestValues;
    }
}
