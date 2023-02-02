package com.company.xx.TOP100.T79单词搜索;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = dfs(0, i, j, word, visited, board);
                return flag;
            }
        }

        return false;
    }

    public boolean dfs(int k, int i, int j, String word, boolean[][] visited, char[][] board) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int l = 0; l < 4; l++) {
            int newI = i + directions[l][0], newJ = j + directions[l][1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                if (!visited[newI][newJ]) {
                    boolean flag = dfs(k + 1, newI, newJ, word, visited, board);
                    if (flag) {
                        return true; // 错误，
                    }
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        new Solution().exist(board, "SEE");
        System.out.println();
    }
}
