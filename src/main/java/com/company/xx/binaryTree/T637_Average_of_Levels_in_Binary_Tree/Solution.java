package com.company.xx.binaryTree.T637_Average_of_Levels_in_Binary_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /********************************************解法1******************************************************/

    /**
     * level order traverse
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> average = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null) {
            return average;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                sum += node.val;
            }
            average.add(sum / size);
        }
        return average;
    }

    /********************************************解法2******************************************************/


    public static void dfs(int level, List<Double> sum, List<Integer> counts, TreeNode root) {
        if (root == null) {
            return;
        }

        if (sum.size() < level + 1) {
            sum.add(root.val + 0.0);
            counts.add(1);
        } else {
            sum.set(level, sum.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        }
        dfs(level + 1, sum, counts, root.left);
        dfs(level + 1, sum, counts, root.right);
    }

    /**
     * dfs
     *
     * @param root
     * @return
     */
    public static List<Double> averageOfLevels2(TreeNode root) {
        List<Double> average = new ArrayList<>();

        if (root == null) {
            return average;
        }
        List<Double> sum = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        int initialLevel = 0;
        dfs(initialLevel, sum, counts, root);
        for (int i = 0; i < sum.size(); i++) {
            average.add(sum.get(i) / counts.get(i));
        }
        return average;
    }

    public static void main(String[] args) {
        System.out.println(averageOfLevels2(TreeUtils.getTree()));
    }
}
