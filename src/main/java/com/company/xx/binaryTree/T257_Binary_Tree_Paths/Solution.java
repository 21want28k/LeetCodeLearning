package com.company.xx.binaryTree.T257_Binary_Tree_Paths;

import com.company.xx.binaryTree.TreeNode;
import com.company.xx.binaryTree.utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> treePaths = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        dfs(nodes, treePaths, root);
        return treePaths;
    }

    public void dfs(List<TreeNode> nodes, List<String> treePaths, TreeNode root) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        // leaf node
        if (root.left == null && root.right == null) {
            StringBuilder builder = new StringBuilder();
            for (TreeNode node : nodes) {
                builder.append(node.val + "->");
            }
            builder.delete(builder.length() - 2, builder.length());
            treePaths.add(builder.toString());

        }
//        nodes.remove(nodes.size() - 1);
        dfs(nodes, treePaths, root.left);
        if (root.left != null) {
            nodes.remove(nodes.size() - 1);
        }
        dfs(nodes, treePaths, root.right);
        if (root.right != null) {
            nodes.remove(nodes.size() - 1);
        }
    }

    /**
     * dfs递归，利用string的拷贝特性，就可以避免回溯了
     *
     * @param path
     * @param treePaths
     * @param root
     */
    public void dfs2(String path, List<String> treePaths, TreeNode root) {
        if (root == null) {
            return;
        }
        StringBuilder builder = new StringBuilder(path);
        builder.append(root.val);
        if (root.left == null && root.right == null) {
            treePaths.add(builder.toString());
        } else {
            builder.append("->");
            dfs2(builder.toString(), treePaths, root.left);
            dfs2(builder.toString(), treePaths, root.right);
        }
    }

    /**
     * iteration，也是利用string的特性避免回溯。
     *
     * @param root
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> treePaths = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        // 每个节点的路径前缀
        Queue<String> paths = new LinkedList<>();
        nodes.offer(root);
        paths.offer(String.valueOf(root.val));
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                String path = paths.poll();
                if (node.left == null && node.right == null) {
                    treePaths.add(path);
                }
                if (node.left != null) {
                    paths.offer(path + "->" + node.left.val);
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    paths.offer(path + "->" + node.right.val);
                    nodes.add(node.right);
                }
            }
        }
        return treePaths;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(solution.binaryTreePaths2(TreeUtils.getTree()));
    }
}
