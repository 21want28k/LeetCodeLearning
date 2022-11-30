package com.company.xx.binaryTree.T637_Average_of_Levels_in_Binary_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                sum += node.val;
            }
            res.add(sum / size);
        }
        return res;
    }

    public static List<Double> averageOfLevels2(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        dfs(root, counts, sums, 0);

        for (int i = 0; i < counts.size(); i++) {
            double avg = 0.0;
            res.add(sums.get(i) / counts.get(i));
        }
        return res;
    }

    public static void dfs(TreeNode root, List<Integer> counts, List<Double> sums, int level) {
        if (root == null) {
            return;
        }

        if (level == counts.size()) {
            counts.add(1);
            sums.add(1.0 * root.val);
        } else {
            counts.set(level, counts.get(level) + 1);
            sums.set(level, sums.get(level) + root.val);
        }
        dfs(root.left, counts, sums, level + 1);
        dfs(root.right, counts, sums, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(averageOfLevels2(root));
    }
}
