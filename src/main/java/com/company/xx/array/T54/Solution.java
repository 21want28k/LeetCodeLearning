package com.company.xx.array.T54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int x_number = m - 1;
        int y_number = n - 1;
        int count = 1;
        int startX = 0;
        int startY = 0;
        while (x_number > 0 && y_number >0) {
            int i = startX;
            int j = startY;
            while (j < startY + y_number) {
                res.add(matrix[i][j++]);
                count++;
            }
            while (i < startX + x_number) {
                res.add(matrix[i++][j]);
                count++;
            }
            while (j > startY) {
                res.add(matrix[i][j--]);
                count++;
            }
            while (i > startX) {
                res.add(matrix[i--][j]);
                count++;
            }
            x_number-=2;
            y_number-=2;
            startX++;
            startY++;
        }
        // 只剩一列
        if (x_number > 0 && y_number == 0) {
            for (int i = startX; i <= startX + x_number; i++) {
                res.add(matrix[i][startY]);
            }
        }
        // 只剩一行（包括只有一个的情况）
        if (y_number >= 0 && x_number == 0) {
            for (int j = startY; j <= startY + y_number; j++) {
                res.add(matrix[startX][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        new Solution().spiralOrder(m);
    }
}
