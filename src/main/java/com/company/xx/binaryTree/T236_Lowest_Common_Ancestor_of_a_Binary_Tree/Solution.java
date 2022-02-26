package com.company.xx.binaryTree.T236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return null;
        }
    }


    HashMap<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left.val, root);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
        }
        dfs(root.left);
        dfs(root.right);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode father = null;
        dfs(root);
        while (p != null) {
            set.add(p.val);
            p = map.get(p.val);
        }
        while (q != null) {
            if (set.contains(q.val)) {
                father = q;
                break;
            }
            q = map.get(q.val);
        }
        return father;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lowestCommonAncestor2(TreeUtils.arraysToTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), new TreeNode(1)));
//        TreeNode root = TreeUtils.arraysToTree(new Integer[]{1, 2});
//        System.out.println(s.lowestCommonAncestor(root, new TreeNode(1), new TreeNode(2)));
    }
}