package com.company.xx.binaryTree.T450_Delete_Node_in_a_BST;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution2 {
//    /**
//     * 这个方法有一个地方没处理好，那就是找某一个节点的前驱（比如左孩子的最右节点，如果这个最右节点还有孩子节点的时候，不能通过简单删除来做。）
//     * @param root
//     * @param key
//     * @return
//     */
//    public TreeNode deleteNode(TreeNode root, int key) {
//        if (root == null) {
//            return null;
//        }
//        if (root.left == null && root.right == null && root.val == key) { // 单节点树
//            return null;
//        }
//        dfs(root, key, null);
//        return root;
//    }
//
//    public void dfs(TreeNode root, int key, TreeNode parent) {
//        if (root == null) {
//            return;
//        }
//        if (root.val == key) {
//            update(root, key, parent);
//        }
//
//        if (key < root.val) {
//            dfs(root.left, key, root);
//        }
//        if (key > root.val) {
//            dfs(root.right, key, root);
//        }
//    }
//
//    public void update(TreeNode root, int key, TreeNode parent) {
//        TreeNode cur, parent1;
//        if (root.left == null && root.right == null) { // 我是叶子节点，删除孩子节点
//            if (parent.left != null && parent.left.val == key) { // 但是我不知道我是父亲的左孩子还是右孩子，所以进行判断
//                parent.left = null;
//            }else {
//                parent.right = null;
//            }
//        } else if (root.left != null) { // 左孩子不等于空，找到左孩子的最右节点进行填充
//            parent1 = root;
//            cur = root.left;
//            while (cur.right != null) {
//                parent1 = cur;
//                cur = cur.right;
//            }
//            root.val = cur.val;
//            if (parent1 == root) {
//                parent1.left = null;
//            } else {
//                parent1.right = null;
//            }
//        } else { // 右孩子不为空，找到右孩子的最左节点进行填充
//            parent1 = root;
//            cur = root.right;
//            while (cur.left != null) {
//                parent1 = cur;
//                cur = cur.left;
//            }
//            root.val = cur.val;
//            if (parent1 == root) {
//                parent1.right = null;
//            } else {
//                parent1.left = null;
//            }
//        }
//    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left != null && root.right == null) {
                return root.left;
            }
            if (root.right != null && root.left == null) {
                return root.right;
            }
            if (root.right != null && root.left != null) {
                TreeNode rightLeftest = findRightLeftest(root);
                root.val = rightLeftest.val;
                root.right = deleteNode(root.right, rightLeftest.val);
            }
        }
        return root;

    }

    private TreeNode findRightLeftest(TreeNode root) {
        TreeNode cur = root.right;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }


    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode2(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode2(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left != null && root.right == null) {
                return root.left; // 用root.left 代替root
            }

            if (root.right != null && root.left == null) {
                return root.right; // 用root.right 代替root
            }
            if (root.right != null && root.left != null) {
                TreeNode cur = root.right; // 把左孩子接到右子树的最左节点去
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right; // 用root.right代替root，这样删除root
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        new Solution2().deleteNode(root, 7);
    }
}
