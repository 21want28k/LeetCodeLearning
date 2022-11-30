package com.company.xx.binaryTree.T199_Binary_Tree_Right_Side_View;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.*;

public class Solution2 {
//    public static List<Integer> rightSideView(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        dfs(root, res);
//        return res;
//    }
//
//    public static void dfs(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        res.add(root.val);
//        if (root.right != null) {
//            dfs(root.right, res);
//        } else {
//            if (root.left != null) {
//                dfs(root.left, res);
//            }
//        }
//    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }


    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, 0, map, res);
        return res;
    }

    public static void dfs(TreeNode root, int level, Map<Integer, Integer> map, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (map.get(level) == null) {
            res.add(root.val);
            map.put(level, root.val);
        }
        dfs(root.right, level + 1, map, res);
        dfs(root.left, level + 1, map, res);
    }

    public static List<Integer> rightSideView3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        dfs2(root, 0, res);
        return res;
    }

    private static void dfs2(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(root.val);
        }
        dfs2(root.right, level+1, res);
        dfs2(root.left, level+1, res);
    }



    public static void main(String[] args) {
        TreeNode node = TreeUtils.constructTree(new Integer[]{1, null, 3});
        System.out.println(rightSideView2(node));
    }
}
