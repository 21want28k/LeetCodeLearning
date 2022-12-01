package com.company.xx.binaryTree.T116_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (i == size - 1) {
                    continue;
                }
                Node next = queue.peek();
                if (next != null) {
                    cur.next = next;
                }
            }
        }
        return root;
    }

    //    public Node connect2(Node root) {
//        if (root == null) {
//            return root;
//        }
//        if (root.left != null) {
//            if (root.right != null) {
//                root.left.next = root.right;
//            } else {
//                if (root.next != null) {
//                    if (root.next.left != null) {
//                        root.left.next = root.next.left;
//                    }else {
//                        root.left.next = root.next.right;
//                    }
//                }
//            }
//        }
//    }
    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect2(root.left);
        connect2(root.right);
        return root;
    }
}
