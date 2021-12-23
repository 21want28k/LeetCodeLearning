package com.company.xx.binaryTree.T429_N_ary_Tree_Level_Order_Traversal;

import java.util.*;

public class Solution {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /********************************************解法1******************************************************/

    /**
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> naryLevelOrder = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();

        if (root == null) {
            return naryLevelOrder;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (!node.children.isEmpty()) {
                    queue.addAll(node.children);
//                    for (Node n : node.children) {
//                        queue.offer(n);
//                    }
                }
                levelNodes.add(node.val);
            }
            naryLevelOrder.add(levelNodes);
        }
        return naryLevelOrder;
    }

    /********************************************解法2******************************************************/

    /**
     * simplified code of former solution1
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> naryLevelOrder = new ArrayList<>();

        if (root == null) {
            return naryLevelOrder;
        }

        List<Node> previousLayer = Collections.singletonList(root);
        while (!previousLayer.isEmpty()) {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> previousLayerVals = new ArrayList<>();
            for (Node node : previousLayer) {
//                if (!node.children.isEmpty()) {
//                    currentLayer.addAll(node.children);
//                }
                currentLayer.addAll(node.children);
                previousLayerVals.add(node.val);
            }
            naryLevelOrder.add(previousLayerVals);
            previousLayer = currentLayer;

        }
        return naryLevelOrder;
    }

    /********************************************解法3******************************************************/


    public static void dfs(Node root, int level, List<List<Integer>> levelNodes) {
        if (root == null) {
            return;
        }
        if (levelNodes.size() == level) {
            levelNodes.add(new ArrayList<>());
        }
        levelNodes.get(level).add(root.val);
        for (Node node : root.children) {
            dfs(node, level + 1, levelNodes);
        }
    }

    /**
     * dfs
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(Node root) {
        List<List<Integer>> naryLevelOrder = new ArrayList<>();

        if (root == null) {
            return naryLevelOrder;
        }
        int initialLevel = 0;
        dfs(root, initialLevel, naryLevelOrder);
        return naryLevelOrder;
    }

}