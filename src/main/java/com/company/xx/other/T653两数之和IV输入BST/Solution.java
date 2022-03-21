package com.company.xx.other.T653两数之和IV输入BST;

import com.company.xx.binaryTree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return true;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) | findTarget(root.right, k);
    }
}
