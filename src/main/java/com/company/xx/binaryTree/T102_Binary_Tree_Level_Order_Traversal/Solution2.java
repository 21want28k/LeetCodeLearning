package com.company.xx.binaryTree.T102_Binary_Tree_Level_Order_Traversal;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.*;

public class Solution2 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> onePath = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                onePath.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(onePath);
        }
        return res;
    }

    static class Node {
        public TreeNode node;
        public int level;

        public Node(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    /**
     * 这种方法有两个注意点
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 1));
        int level = 1;
        List<Integer> onePath = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.node.left != null) {
                queue.add(new Node(node.node.left, level + 1));
            }
            if (node.node.right != null) {
                queue.add(new Node(node.node.right, level + 1));
            }
            if (node.level == level) {
                onePath.add(node.node.val);
            } else {
                level++;
                res.add(onePath);
                onePath = new ArrayList<>();
                onePath.add(node.node.val); // 注意点1，遇到新一层的节点的时候，要记得先加入，已经出队列了，之后就不会遍历到它
            }
        }
        res.add(onePath); // 注意点2，在最后一层的时候，结果中还没有加入到它。
        return res;
    }


    public static List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    public static void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);
    }


    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7});
//        levelOrder2(root);
    }
}
