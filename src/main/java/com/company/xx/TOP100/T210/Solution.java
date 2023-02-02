package com.company.xx.TOP100.T210;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> list;
    int[] visited;
    int[] result; // 当栈用
    int index; //栈标记 n-1代表栈顶
    boolean valid = true; // 是否有环（合法）true 合法，没有环。

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        result = new int[numCourses];
        list = new ArrayList<>();
        int n = prerequisites.length;
        index = numCourses - 1;
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) { // 构建邻接表，这里需要注意的是,prerequisites[i][1]是前驱,prerequisites[i][0]是后继
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {// 有环。
            return new int[]{};
        } else {
            return result;
        }
    }

    public void dfs(int i) {
        visited[i] = 1;
        for (int u : list.get(i)) { // 遍历邻接表里面的所有的后继节点
            if (visited[u] == 0) { // 没访问过，继续dfs
                dfs(u);
                if (!valid) { // 这里是关键，要弄明白如果出现环，直接return，回一级一级return。
                    return;
                }
            } else if (visited[u] == 1) { // 出现环
                valid = false; // 环标记
                return;
            }
        }
        visited[i] = 2; //代表已经完成了，也就是i的后继节点都访问过了。
        result[index--] = i; // i入栈
    }

    public static void main(String[] args) {
        new Solution().findOrder(10, new int[][]{{0, 1}});
    }
}