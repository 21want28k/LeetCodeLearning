package com.company.xx.binaryTree.T513_Find_Bottom_Left_Tree_Value;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class Cache {
        int bottomLeftV;
        int maxDepth;
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Cache cache = new Cache();
        cache.bottomLeftV = root.val;
        cache.maxDepth = 1;
        traverse(root, 1, cache);
        return cache.bottomLeftV;
    }

    public void traverse(TreeNode root, int depth, Cache cache) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && depth > cache.maxDepth) {
            cache.maxDepth = depth;
            cache.bottomLeftV = root.val;
        }
        traverse(root.left, depth + 1, cache);
        traverse(root.right, depth + 1, cache);
    }

    public int findBottomLeftValue2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int maxDepth = -1;
        int depth = 0;
        int bottomLeftValue = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left == null && treeNode.right == null && depth > maxDepth) {
                    maxDepth = depth;
                    bottomLeftValue = treeNode.val;
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            depth++;
        }
        return bottomLeftValue;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findBottomLeftValue2(TreeUtils.getTree()));
    }
}
