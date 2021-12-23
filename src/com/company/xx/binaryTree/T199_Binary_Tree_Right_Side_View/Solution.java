package com.company.xx.binaryTree.T199_Binary_Tree_Right_Side_View;

import com.company.xx.binaryTree.TreeNode;

import java.util.*;

public class Solution {
    /********************************************解法1******************************************************/
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return result;
        }

        queue.offer(root);
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
                    result.add(node.val);
                }
            }
        }
        return result;
    }

    /********************************************解法2******************************************************/

    /**
     * get postorder list and retrieve the first level number of items.
     * fail
     * 1
     * / \
     * 2   3
     * /
     * 4
     *
     * @param root
     * @param result
     * @return
     */
    public static int recursion(TreeNode root, List<Integer> result) {
        if (root == null) {
            return 0;
        }
        result.add(root.val);
        int rightLevel = recursion(root.right, result);
        int leftLevel = recursion(root.left, result);
        return Math.max(leftLevel, rightLevel) + 1;
    }

    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int level;
        level = recursion(root, result);
        return result.subList(0, level);
    }

    /********************************************解法3******************************************************/

    public static int recursion2(TreeNode root, int level, List<Integer> result, List<Integer> levels) {
        if (root == null) {
            return 0;
        }
        result.add(root.val);
        levels.add(level);
        int rightLevel = recursion2(root.right, level + 1, result, levels);
        int leftLevel = recursion2(root.left, level + 1, result, levels);
        return Math.max(leftLevel, rightLevel) + 1;
    }

    /**
     * revise the former method
     *
     * @param root
     * @return
     */
    public static List<Integer> rightSideView3(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        List<Integer> treeNodes = new ArrayList<>();
        List<Integer> levels = new ArrayList<>();
        if (root == null) {
            return treeNodes;
        }
        int level = 1;
        int maxLevel = recursion2(root, level, treeNodes, levels);
        System.out.println(treeNodes);
        System.out.println(levels);
        System.out.println(maxLevel);

        int countLevel = 1;
        for (int i = 0; i < levels.size(); i++) {
            if (countLevel > maxLevel) {
                return rightView;
            }
            if (levels.get(i) == countLevel) {
                rightView.add(treeNodes.get(i));
                countLevel++;
            }
        }
        return rightView;
    }

    /********************************************解法4******************************************************/


    /**
     * non-recursion implementation of method3
     *
     * @param root
     * @return
     */
    public static List<Integer> rightSideView4(TreeNode root) {
        Map<Integer, TreeNode> map = new HashMap<>();
        List<Integer> rightView = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> levelStack = new Stack<>();

        if (root == null) {
            return rightView;
        }
        int level = 0;
        int maxLevel = -1;

        TreeNode cur = root;
        while (cur != null || !nodeStack.isEmpty()) {
            if (cur != null) {
                level++;
                maxLevel = Math.max(maxLevel, level);
                if (map.get(level) == null) {
                    map.put(level, cur);
                }
                nodeStack.push(cur);
                levelStack.push(level);
                cur = cur.right;
            } else {
                cur = nodeStack.pop();
                level = levelStack.pop();
                cur = cur.left;
            }
        }
        System.out.println(map);
        System.out.println(maxLevel);
        for (int i = 1; i <= maxLevel; i++) {
            rightView.add(map.get(i).val);
        }
        return rightView;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        System.out.println(rightSideView2(TreeUtils.getTree()));
        System.out.println(rightSideView4(root));
    }
}