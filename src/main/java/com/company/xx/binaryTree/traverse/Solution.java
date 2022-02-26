package com.company.xx.binaryTree.traverse;

import com.company.xx.binaryTree.Node;
import com.company.xx.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    // root left right
    public static void preOrderTraverse(Node root, List<Node> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        preOrderTraverse(root.left, nodes);
        preOrderTraverse(root.right, nodes);
    }

    // left root right
    public static void inOrderTraverse(Node root, List<Node> nodes) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, nodes);
        nodes.add(root);
        inOrderTraverse(root.right, nodes);
    }

    // left  right root
    public static void postOrderTraverse(Node root, List<Node> nodes) {
        if (root == null) {
            return;
        }
        postOrderTraverse(root.left, nodes);
        postOrderTraverse(root.right, nodes);
        nodes.add(root);
    }

    // root left right 非递归
    public static void preOrderTraverse2(Node root, List<Node> nodes) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                nodes.add(cur);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    // left root right 非递归
    public static void inOrderTraverse2(Node root, List<Node> nodes) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                nodes.add(cur);
                cur = cur.right;
            }
        }
    }

    // left right root 非递归，
    // first step: root right left
    // second step: post order output nodes
    public static void postOrderTraverse2(Node root, List<Node> nodes) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                nodes.add(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                cur = cur.left;
            }
        }
    }

    // left right root 非递归，
    public static void postOrderTraverse3(Node root, List<Node> nodes) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node pre = null; // store previous visited node
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                // two conditions:
                //   - don't have right node
                //   - right node has been visited
                if (cur.right == null || pre == cur.right) {
                    // visit node
                    nodes.add(cur);
                    pre = cur;
                    cur = null; // cur has been bushed into the stack in the past, pop the top of stack directly
                } else {
                    // push the popped root into stack
                    stack.push(cur);
                    cur = cur.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
            1
           /  \
          2   3
         /
        4
         */
        List<Node> list = new ArrayList<>();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        postOrderTraverse3(root, list);
//        Collections.reverse(list);
        System.out.println(list);
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                result.add(cur.val);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (cur.right == null || pre == cur.right) {
                    list.add(cur.val);
                    pre = cur;
                    cur = null;
                } else {
                    stack.push(cur);
                    cur = cur.right;
                }
            }
        }
        return list;
    }
}
