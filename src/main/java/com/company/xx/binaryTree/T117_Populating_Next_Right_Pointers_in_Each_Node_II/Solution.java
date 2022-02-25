package com.company.xx.binaryTree.T117_Populating_Next_Right_Pointers_in_Each_Node_II;

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

    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node leftest = root;
        while (leftest != null) {
            // current layer index
            Node cur = leftest;
            Node nextHead = null;
            Node tail = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (nextHead == null) {
                        nextHead = cur.left;
                    }
                    if (tail == null) {
                        tail = cur.left;
                    } else {
                        tail.next = cur.left;
                        tail = tail.next;
                    }
                }
                if (cur.right != null) {
                    if (nextHead == null) {
                        nextHead = cur.right;
                    }
                    if (tail == null) {
                        tail = cur.right;
                    } else {
                        tail.next = cur.right;
                        tail = tail.next;
                    }
                }
                cur = cur.next;
            }
            leftest = nextHead;
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
        connect(root);
    }
}
