package com.company.xx.binaryTree.T101_Symmetric_Tree;

import com.company.xx.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    /**
     * 用的是双端队列，事实上可以用单队列
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root.left);
        deque.add(root.right);
        while (!deque.isEmpty()) {
            TreeNode first = deque.removeFirst();
            TreeNode last = deque.removeLast();
            if (first != null && last == null) {
                return false;
            }
            if (first == null && last != null) {
                return false;
            }
            if (first == null && last == null) {
                continue;
            }
            if (first.val != last.val) {
                return false;
            }
            deque.addFirst(first.right);
            deque.addFirst(first.left);
            deque.addLast(last.left);
            deque.addLast(last.right);
        }
        return true;
    }

    /**
     * 单队列的写法。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right != null) {
                return false;
            }
            if (left != null && right == null) {
                return false;
            }
            if (left == null && right == null) {
                continue;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.right);
            queue.offer(right.left);
            queue.offer(left.left);
            queue.offer(right.right);
        }
        return true;
    }

    public boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check222(root.left, root.right);
    }

    private boolean check222(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return check222(left.right, right.left) && check222(left.left, right.right);
    }

//    public boolean check(TreeNode left, TreeNode right) {
//
//    }
}
