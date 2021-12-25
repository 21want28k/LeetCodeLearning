package com.company.xx.binaryTree.T101_Symmetric_Tree;

import com.company.xx.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static boolean isSymmetric(TreeNode root) {
        boolean isSymmetric = true;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return true;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node);
                queue.add(node.left);
                queue.add(node.right);
            }
            isSymmetric = check(list);
            if (check(list) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean check(List<TreeNode> list) {
        boolean isSymmetric = true;
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (list.get(i).val != list.get(j).val) {
                isSymmetric = false;
                break;
            }
            i++;
            j--;
        }
        return isSymmetric;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(null);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(null);
        linkedList.add(null);
//        System.out.println(isSymmetric(root));
    }
}