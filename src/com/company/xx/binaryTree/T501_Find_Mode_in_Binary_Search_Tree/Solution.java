package com.company.xx.binaryTree.T501_Find_Mode_in_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> result = new ArrayList<>();
    int base = Integer.MIN_VALUE;
    int count = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        traverse(root);
        int[] mode = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            mode[i] = result.get(i);
        }
        return mode;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        update(root);
        traverse(root.right);
    }

    private void update(TreeNode root) {
        if (base == root.val) {
            count++;
        } else {
            count = 1;
            base = root.val;
        }
        if (count == maxCount) {
            result.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(base);
        }
    }

    public void traverse2(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) {
//                System.out.println(cur);
                update(cur);
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
//                System.out.println(cur);
                update(cur);
                cur = cur.right;
            }
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(2);
        Solution s = new Solution();
        TreeNode root = new TreeNode(0);
        Integer[] array = new Integer[]{1, 0, 1, 0, 0, 1, 1, 0};

        int[] mode = s.findMode(TreeUtils.arraysToTree(array));
    }
}
