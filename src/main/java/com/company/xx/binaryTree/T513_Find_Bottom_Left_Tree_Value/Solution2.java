package com.company.xx.binaryTree.T513_Find_Bottom_Left_Tree_Value;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

public class Solution2 {
    int level1;
    int res;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (level > level1) {
                level1 = level;
                res = root.val;
            }
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtils.constructTree(new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7});
        new Solution2().findBottomLeftValue(node);
    }
}
