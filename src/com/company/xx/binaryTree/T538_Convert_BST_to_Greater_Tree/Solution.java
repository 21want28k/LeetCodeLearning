package com.company.xx.binaryTree.T538_Convert_BST_to_Greater_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*错误解法1*/
    List<Integer> list = new ArrayList<>();

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        traverse(root);
        int n = list.size();
        for (int i = n - 2; i >= 0; i--) {
            list.set(i, list.get(i) + list.get(i + 1));
        }
        return traverse2(list, 0, n - 1);
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }

    public TreeNode traverse2(List<Integer> nums, int first, int last) {
        if (first > last) {
            return null;
        }
        int mid = (first + last) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = traverse2(nums, first, mid - 1);
        root.right = traverse2(nums, mid + 1, last);
        return root;
    }

    /*正确解法1*/
    public TreeNode convertBST2(TreeNode root) {
        traverse3(root);
        return root;
    }

    TreeNode pre = new TreeNode(0);

    int sum = 0;

    public void traverse3(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse3(root.right);
        sum += root.val;
        root.val = sum;
//        root.val += pre.val;
//        pre = root;
        traverse3(root.left);
    }

    public void traverse4(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse4(root.right);
//        sum += root.val;
//        root.val = sum;
        root.val += pre.val;
        pre = root;
        traverse4(root.left);
    }

    /*利用Morris中序遍历的正确解法2*/
    public TreeNode morris(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        int sum = 0;
        while (cur != null) {
            if (cur.right == null) {
                System.out.println(cur);
                sum += cur.val;
                cur.val = sum;
                cur = cur.left;
            } else {
                pre = cur.right;
                while (pre.left != null && pre.left != cur) {
                    pre = pre.left;
                }
                if (pre.left == null) {
                    pre.left = cur;
                    cur = cur.right;
                }
                if (pre.left == cur) {
                    pre.left = null;
                    System.out.println(cur);
                    sum += cur.val;
                    cur.val = sum;
                    cur = cur.left;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        Solution s = new Solution();
        TreeNode node = s.morris(root);
    }
}