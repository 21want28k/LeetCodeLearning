package com.company.xx.binaryTree.T572_Subtree_of_Another_Tree;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    /**
     * 暴力解法
     *
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return check(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return check(p.left, q.left) && check(p.right, q.right);
    }

    public static void getString(TreeNode root, StringBuilder r) {
        if (root == null) {
            return;
        }
        r.append(root.val).append(",");
        if (root.left != null) {
            getString(root.left, r);
        } else {
            r.append("n,");
        }
        if (root.right != null) {
            getString(root.right, r);
        } else {
            r.append("n,");
        }
    }

    public static boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        StringBuilder r = new StringBuilder(), s = new StringBuilder();
        getString(root, r);
        getString(subRoot, s);
        return r.toString().contains(s.toString());
    }

    public boolean isSubtree3(TreeNode root, TreeNode subRoot) {
        int n = 100000;
        int[] prime = oula(n);
        int mode = 70000;
        Map<TreeNode, int[]> rootMap = new HashMap<>();
        Map<TreeNode, int[]> subRootMap = new HashMap<>();
        dfs(root, rootMap, prime, mode);
        dfs(subRoot, subRootMap, prime, mode);
        int subRootHash = subRootMap.get(subRoot)[0];
        for (Map.Entry<TreeNode, int[]> entry : rootMap.entrySet()) {
            if (entry.getValue()[0] == subRootHash) {
                return true;
            }
        }
        return false;
    }

    //    public void dfs(TreeNode node, Map<TreeNode, int[]> map, int[] prime, int mod) {
//
//        map.put(node, new int[]{node.val, 1});
//        if (node.left == null && node.right == null) {
//            return;
//        }
//        if (node.left != null) {
//            dfs(node.left, map, prime, mod);
//
//            int[] val = map.get(node);
//            val[1] += map.get(node.left)[1];
//            val[0] = (int) (val[0] + 31L * map.get(node.left)[0] * prime[map.get(node.left)[1]]) % mod;
//        }
//        if (node.right != null) {
//            dfs(node.right, map, prime, mod);
//
//            int[] val = map.get(node);
//            val[1] += map.get(node.right)[1];
//            val[0] = (int) (val[0] + 179L * map.get(node.right)[0] * prime[map.get(node.right)[1]]) % mod;
//        }
//    }
    public void dfs(TreeNode node, Map<TreeNode, int[]> map, int[] prime, int mod) {
        if (node == null) {
            return;
        }
        map.put(node, new int[]{node.val, 1});
        dfs(node.left, map, prime, mod);
        dfs(node.right, map, prime, mod);
        if (node.left != null) {
            int[] val = map.get(node);
            val[1] += map.get(node.left)[1];
            val[0] = (int) (val[0] + 31L * map.get(node.left)[0] * prime[map.get(node.left)[1]]) % mod;
        }
        if (node.right != null) {
            int[] val = map.get(node);
            val[1] += map.get(node.right)[1];
            val[0] = (int) (val[0] + 179L * map.get(node.right)[0] * prime[map.get(node.right)[1]]) % mod;
        }
    }


    public static int[] oula(int n) {
        boolean[] sifted = new boolean[n + 1]; // 代表1～n个数字 true代表被筛掉了，false代表没有被筛掉
        int[] prime = new int[n]; // 素数数组
        int point = 0; // 素数的指针
        for (int x = 2; x <= n; x++) {
            if (!sifted[x]) { // 如果没有被筛掉
                prime[point++] = x;
            }
            for (int j = 0; j <= point; j++) { // 遍历素数数组，通过y值进行筛选，被筛选掉的要做记录，退出条件是x能整除y<=>x%y==0
                int y = prime[j];
                if (x * y > n) { // 当x*y是，比n大的数，没必要筛选，因为不在考虑范围之内。
                    break;
                }
                sifted[y * x] = true;
                if (x % y == 0) {
                    break;
                }
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructTree(new Integer[]{1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, 2
        });
        TreeNode subRoot = TreeUtils.constructTree(new Integer[]{1, null, 1, null, 1, null, 1, null, 1, null, 1, 2});
        isSubtree2(root, subRoot);
        int[] sushu = oula(7);
        System.out.println(Arrays.toString(sushu));
    }
}
