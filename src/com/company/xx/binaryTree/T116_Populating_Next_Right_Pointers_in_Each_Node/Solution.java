package com.company.xx.binaryTree.T116_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Solution {
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

    /********************************************解法1******************************************************/

    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i < size - 1) {
                    node.next = queue.peek();
                }
            }
        }
        return root;
    }

    /********************************************解法2******************************************************/

    public static Node connect2(Node root) {
        Stack<Node> nodeStack = new Stack<>();
        Node cur = root;
        while (cur != null || !nodeStack.isEmpty()) {
            if (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.next != null && cur.right != null) {
                    cur.right.next = cur.next.left;
                }
                nodeStack.push(cur);
                cur = cur.left;
                // visit
            } else {
                cur = nodeStack.pop();
                cur = cur.right;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        connect3(root);
    }


    /********************************************解法3******************************************************/
    /**
     * @param root
     * @return
     */
    public static Node connect3(Node root) {
        if (root == null) {
            return root;
        }
        Node leftest = root;
        while (leftest.left != null) {
            Node head = leftest;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftest = leftest.left;
        }
        return root;
    }

    /********************************************解法4******************************************************/


    public static void recursion(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        recursion(root.left);
        recursion(root.right);
    }

    /**
     * recursion
     *
     * @param root
     * @return
     */
    public static Node connect4(Node root) {
        Node cur = root;
        recursion(root);
        return root;
    }
}
