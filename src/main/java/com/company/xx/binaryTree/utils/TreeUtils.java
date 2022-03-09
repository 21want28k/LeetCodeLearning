package com.company.xx.binaryTree.utils;

import com.company.xx.binaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class TreeUtils {
    /**
     * 1
     * / \
     * 2   3
     * / \ / \
     * 4  56  7
     *
     * @return
     */
    public static TreeNode getTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static TreeNode arraysToTree(Integer[] arrays) {
        if (arrays.length == 0) {
            return null;
        }
        return traverse(arrays, 0);
    }

    public static TreeNode traverse(Integer[] arrays, int index) {
        if (index > arrays.length - 1 || arrays[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arrays[index]);
        root.left = traverse(arrays, 2 * index + 1);
        root.right = traverse(arrays, 2 * index + 2);
        return root;
    }

    public static TreeNode constructTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        int index = 0;
        int length = array.length;

        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        TreeNode currNode;

        while (index < length) {
            // index指向的永远是孩子节点
            index++;
            if (index >= length) {
                return root;
            }
            // 父亲节点
            currNode = nodeQueue.poll();
            Integer leftChild = array[index];
            if (leftChild != null) {
                currNode.left = new TreeNode(leftChild);
                nodeQueue.offer(currNode.left);
            }

            index++;
            if (index >= length) {
                return root;
            }
            Integer rightChild = array[index];
            if (rightChild != null) {
                currNode.right = new TreeNode(rightChild);
                nodeQueue.offer(currNode.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = constructTree(new Integer[]{3, 0, 4, null, 2, null, null, 1});
    }
}
