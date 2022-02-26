package com.company.xx.剑指offer.剑指Offer_32_III_从上到下打印二叉树_III;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> dequeue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int depth = 1;
        dequeue.push(root);
        while (!dequeue.isEmpty()) {
            List<Integer> path = new ArrayList<>();
            int size = dequeue.size();
            TreeNode cur;
            for (int i = 0; i < size; i++) {
                if (depth % 2 == 1) {
                    cur = dequeue.removeFirst();
                    if (cur.left != null) {
                        dequeue.addLast(cur.left);
                    }
                    if (cur.right != null) {
                        dequeue.addLast(cur.right);
                    }
                } else {
                    cur = dequeue.removeLast();
                    if (cur.right != null) {
                        dequeue.addFirst(cur.right);
                    }
                    if (cur.left != null) {
                        dequeue.addFirst(cur.left);
                    }
                }
                path.add(cur.val);
            }
            depth++;
            result.add(path);
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        int depth = 1;
        queue.push(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> path = new LinkedList<>();
            int size = queue.size();
            TreeNode cur;
            for (int i = 0; i < size; i++) {
                cur = queue.removeFirst();
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
                if (depth % 2 == 1) {
                    path.addLast(cur.val);
                } else {
                    path.addFirst(cur.val);
                }
            }
            depth++;
            result.add(path);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().levelOrder2(TreeUtils.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
