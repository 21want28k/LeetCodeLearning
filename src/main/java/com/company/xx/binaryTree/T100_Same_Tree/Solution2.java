package com.company.xx.binaryTree.T100_Same_Tree;

import com.company.xx.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode pPoll = queue.poll();
            TreeNode qPoll = queue.poll();
            if (pPoll == null && qPoll == null) {
                continue;
            } else if (pPoll == null || qPoll == null || pPoll.val != qPoll.val) {
                return false;
            } else {
                queue.offer(pPoll.left);
                queue.offer(qPoll.left);
                queue.offer(pPoll.right);
                queue.offer(qPoll.right);
            }
        }
        return true;
    }
}
