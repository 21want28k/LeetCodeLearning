package com.company.xx.TOP100.T200;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int numIslands(char[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int l = 0; l < size; l++) {
                            int[] location = queue.poll();
                            int x = location[0], y = location[1];
                            grid[x][y] = '0';
                            int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
                            for (int k = 0; k < 4; k++) {
                                int newI = x + directions[k][0];
                                int newJ = y + directions[k][1];
                                if (newI < 0 || newI > m - 1 || newJ < 0 || newJ > n - 1 || grid[newI][newJ] == '0') {
                                    continue;
                                }
                                queue.offer(new int[]{newI, newJ});
                                // grid[newI][newJ] = '0';
                            }
                        }

                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        new Solution().numIslands(grid);
    }
}