package com.company.xx.剑指offer.剑指Offer_12_矩阵中的路径;

import com.company.xx.utils.MyStringUtils;

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (recursion(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean recursion(char[][] board, String word, int i, int j, int index) {
        boolean flag = false;
        // 越界或者字符不相等 返回false
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        // word所有的数字都已经在数组中找到了
        if (index == word.length() - 1) {
            return true;
        }
        board[i][j] = '\n';
        // 递归四个方向有一个方向成功就返回true
        flag = recursion(board, word, i - 1, j, index + 1) || recursion(board, word, i + 1, j, index + 1)
                || recursion(board, word, i, j + 1, index + 1) || recursion(board, word, i, j - 1, index + 1);
        // 将走过的路恢复起来，不然下次尝试另外一个起点的时候，之前的走过的路就不能再用了
        board[i][j] = word.charAt(index);

        return flag;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]";
        System.out.println(MyStringUtils.replaceBracketsToBraces(s1).replaceAll("\"", "'"));
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = new String("ABCCED");
        System.out.println(s.exist(board, word));
    }
}
