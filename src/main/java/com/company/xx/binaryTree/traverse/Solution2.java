package com.company.xx.binaryTree.traverse;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.*;


public class Solution2 {

    /**
     * 前序遍历二叉树 root，left，right
     *
     * @param root
     * @param list
     * @return
     */
    public static void preTraverse(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preTraverse(root.left, list);
        preTraverse(root.right, list);
    }

    /**
     * 中序遍历，left root right
     *
     * @param root
     * @param list
     */
    public static void inOrderTraverse(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, list);
        list.add(root);
        inOrderTraverse(root.right, list);
    }

    public static void postOrderTraverse(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, list);
        inOrderTraverse(root.right, list);
        list.add(root);
    }

    /**
     * 先序非递归实现
     *
     * @param root
     * @param list
     */
    public static void preTraverse2(TreeNode root, List<TreeNode> list) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        stack.push(root);
        while (curr != null || !stack.isEmpty()) {
            curr = stack.pop();
            list.add(curr);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

    /**
     * 先序非递归实现
     *
     * @param root
     * @param list
     */
    public static void preTraverse3(TreeNode root, List<TreeNode> list) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                list.add(curr);
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                curr = curr.right;
            }
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = root;
//        while (curr != null || !stack.isEmpty()) {
//            if (curr != null) {
//                list.add(curr.val);
//                stack.push(curr);
//                curr = curr.left;
//            } else {
//                curr = stack.pop();
//                curr = curr.right;
//            }
//        }
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                list.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return list;
    }

    public List<Integer> midOrderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;

        }
        return list;
    }


    public static List<Integer> postOrderTraverse2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre = null;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            if (curr.right == null || curr.right == pre) {
                list.add(curr.val);
                pre = curr;
                stack.pop();
                curr = null;
            } else {
                curr = curr.right;
            }

        }
        return list;
    }

    // --------------------------------------------morris算法解决三种非递归遍历--------------------------------------------
    public static void preOrdermorris(TreeNode root, List<TreeNode> list) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                list.add(cur);
                cur = cur.right;
            } else {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    list.add(cur);
                    cur = cur.left;
                    continue;
                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public static void inOrderMorris(TreeNode root, List<TreeNode> list) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                list.add(cur);
                cur = cur.right;
            } else {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostRight.right == cur) {
                    list.add(cur);
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public static void inOrderMorris2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                list.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (mostRight.right == cur) {
                    list.add(cur.val);
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public static List<Integer> postOrderMirros(TreeNode head) {
        List<Integer> res = new ArrayList<>();
        if (head == null) {
            return res;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    addPath(cur.left, res);
                }
            }
            cur = cur.right;
        }
        addPath(head, res);
        return res;
    }

    /**
     * 遍历+翻转存入的节点值，利用的还是原来的空间，不会增加额外的空间了。
     * @param node
     * @param list
     */
    public static void addPath(TreeNode node, List<Integer> list) {
        int count = 0;
        while (node != null) {
            count++;
            list.add(node.val);
            node = node.right;
        }
        int left = list.size() - count;
        int right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            right--;
            left++;
        }
    }


    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree(new Integer[]{3, 0, 4, null, 2, null, null, 1});
        ArrayList<TreeNode> list = new ArrayList<>();
//        preTraverse(root, list); // [TreeNode{val=3}, TreeNode{val=0}, TreeNode{val=2}, TreeNode{val=1}, TreeNode{val=4}]
//        inOrderTraverse(root, list);
//        inOrderMorris(root, list);
        postOrderTraverse2(root);
        System.out.println(list);
    }
}
