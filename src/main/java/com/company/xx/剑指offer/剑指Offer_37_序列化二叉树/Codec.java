package com.company.xx.剑指offer.剑指Offer_37_序列化二叉树;

import com.company.xx.binaryTree.Solution;
import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder("[");
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    builder.append(node.val + ",");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    builder.append("null,");
                }
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        data = data.substring(1, data.length() - 1);
        String[] strings = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strings[index]));
        queue.add(root);
        while (index != strings.length - 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                index++;
                TreeNode n = queue.poll();
                String valueStr = strings[index];
                if (!"null".equals(valueStr)) {
                    n.left = new TreeNode(Integer.parseInt(valueStr));
                    queue.add(n.left);
                }
                index++;
                valueStr = strings[index];
                if (!"null".equals(valueStr)) {
                    n.right = new TreeNode(Integer.parseInt(valueStr));
                    queue.add(n.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] value = {1, 2, 3, null, null, 4, 5};
        TreeNode root = TreeUtils.constructTree(value);
        System.out.println(new Codec().deserialize("[1,2,3,null,null,4,5,null,null,null,null]"));
    }
}
