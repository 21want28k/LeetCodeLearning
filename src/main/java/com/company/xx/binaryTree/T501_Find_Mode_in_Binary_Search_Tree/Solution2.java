package com.company.xx.binaryTree.T501_Find_Mode_in_Binary_Search_Tree;

import com.company.xx.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    int[] res;
    List<Integer> list = new ArrayList<>();
    TreeNode pre = null;
    int count = 1;
    int continues = 1;

    public int[] findMode(TreeNode root) {
        dfs(root);
        res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == null) {
            pre = root;
            list.add(root.val);
        } else {
            if (pre.val == root.val) { // 出现相同的数
                count++;
            } else { // 出现不同的数
                count = 1;
                pre = root;
            }
            if (count == continues) { // 频次相等
                list.add(root.val);
            }
            if (count > continues) { // 频次大于它了
                list.clear();
                list.add(root.val);
                continues = count;
            }
            // 思考一下如果这样写会发生什么
//            if (count > continues) { // 频次大于它了
//                list.clear();
//                list.add(root.val);
//                continues = count;
//            }
//            if (count == continues) { // 频次相等
//                list.add(root.val);
//            }
        }
    }

}
