package com.company.xx.binaryTree.Morris;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution {
    public void traverse(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) {
                System.out.println(cur);
                cur = cur.right;
                // 加continue的作用就在于 最后的时候cur.right == null了，
                // 运行pre = cur.left;空指针异常
                continue;
            }
            pre = cur.left;
            // 开始找最右侧的节点，也就是cur的前驱节点，
            // 加pre.right != cur是因为，如果是已经构建后继的节点，pre.right会回到cur上，
            // 就不是最右下的那个节点了
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }

            // 构建后继节点的过程
            if (pre.right == null) {
                pre.right = cur;
                // cur继续向左构建后继节点
                cur = cur.left;
            }
            // 已经构建了节点了，说明之前访问过pre了，这个时候开业继续访问cur了
            if (pre.right == cur) {
                pre.right = null;
                System.out.println(cur);
                cur = cur.right;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.traverse(TreeUtils.getTree());
    }
}
