package com.company.xx.binaryTree.T117_Populating_Next_Right_Pointers_in_Each_Node_II;

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
        // cur是当前行的遍历指针
        Node cur = root;
        while (cur != null) {
            // h是下一行的头节点，nextLevel是下一行的遍历指针。
            Node h = new Node(-1);
            Node nextLevel = h;
            // 对当前行进行遍历
            while (cur != null) {
                // 如果当前行的左节点为空就用通过下一行的指针，链接上
                if (cur.left != null) {
                    nextLevel.next = cur.left;
                    nextLevel = nextLevel.next;
                }
                // 同理
                if (cur.right != null) {
                    nextLevel.next = cur.right;
                    nextLevel = nextLevel.next;
                }
                cur = cur.next;
            }
            // 切换到下一行
            cur = h.next;
        }
        return root;
    }
}
