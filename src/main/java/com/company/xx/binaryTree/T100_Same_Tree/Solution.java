package com.company.xx.binaryTree.T100_Same_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.offer(p);
        qQueue.offer(q);
        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            int pSize = pQueue.size();
            int qSize = qQueue.size();
            if (pSize != qSize) {
                return false;
            }
            for (int i = 0; i < pSize; i++) {
                TreeNode pNode = pQueue.poll();
                TreeNode qNode = qQueue.poll();
                if (pNode == null && qNode == null) {
                    continue;
                }
                if (pNode == null && qNode != null) {
                    return false;
                }
                if (pNode != null && qNode == null) {
                    return false;
                }
                if (pNode.val != qNode.val) {
                    return false;
                }
                pQueue.offer(pNode.left);
                pQueue.offer(pNode.right);
                qQueue.offer(qNode.left);
                qQueue.offer(qNode.right);
            }
        }
        return pQueue.size() == qQueue.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSameTree2(TreeUtils.getTree(), TreeUtils.getTree()));
    }
}