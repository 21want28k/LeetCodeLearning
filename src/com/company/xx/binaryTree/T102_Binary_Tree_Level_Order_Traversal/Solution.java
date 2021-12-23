package com.company.xx.binaryTree.T102_Binary_Tree_Level_Order_Traversal;

import com.company.xx.binaryTree.TreeNode;

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

    static class Node {
        TreeNode treeNode;
        int level;

        public Node() {
        }

        public Node(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<Node> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        queue.add(new Node(root, 1));
        int level = 1;
        List<Integer> levelNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nodeLevel = node.level;
            if (node.treeNode.left != null) {
                queue.add(new Node(node.treeNode.left, nodeLevel + 1));
            }
            if (node.treeNode.right != null) {
                queue.add(new Node(node.treeNode.right, nodeLevel + 1));
            }
            if (nodeLevel == level) {
                levelNodes.add(node.treeNode.val);
            } else {
                result.add(levelNodes);
                level++;
                levelNodes = new ArrayList<>();
                levelNodes.add(node.treeNode.val);
            }
        }
        result.add(levelNodes);
        return result;
    }

    public static List<List<Integer>> levelOrder3(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int initialLevel = 0;
        dfs(root, initialLevel, result);
        return result;
    }


    /**
     * @param node
     * @param level begin with 0
     * @param result
     */
    public static void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        // be careful: the size is always one bigger than the level,
        if (result.size() == level) {
            // add this level of list into result and size+1.
            // Next if statement will be false in the same level.
            // So the operation of adding new arrayList will only be performed once.
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(levelOrder3(root));
//        List<Integer> list = new ArrayList<>();
    }
}