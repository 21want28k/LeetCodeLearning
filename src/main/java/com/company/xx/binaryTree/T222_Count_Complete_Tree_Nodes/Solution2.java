package com.company.xx.binaryTree.T222_Count_Complete_Tree_Nodes;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int lh = 0;
        int rh = 0;
        while (left != null) {
            lh++;
            left = left.left;
        }
        while (right != null) {
            rh++;
            right = right.right;
        }
        if (lh == rh) {
            return (1 << (lh + 1)) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode cur = root;
        while (cur != null) {
            level++;
            cur = cur.left;
        }
        level--;
        int low = 1 << level;
        int high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (check(mid, level, root)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static boolean check(int mid, int level, TreeNode root) {
        int bit = 1 << (level - 1);
        TreeNode cur = root;
        while (cur != null && bit > 0) {
            if ((bit & mid) == 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
            bit >>= 1;
        }
        return cur != null;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree(new Integer[]{});
        System.out.println(countNodes2(root));
    }
}
