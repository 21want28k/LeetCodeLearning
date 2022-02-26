package com.company.xx.array.T59_Spiral_Matrix_II;

import java.util.Arrays;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int startX = 0; // 每次开始的x的坐标
        int startY = 0; // 每次开始的y的坐标
        int count = 1; // 从1~n^2
        int number = n - 1; // 每一行的个数
        while (count < n * n) {
            int i = startX;
            int j = startY;

            for (; j < startY + number; j++) {
                result[startX][j] = count++;
            }
            for (; i < startX + number; i++) {
                result[i][j] = count++;
            }
            for (; j > startX; j--) {
                result[i][j] = count++;
            }
            for (; i > startY; i--) {
                result[i][j] = count++;
            }

            startX++;
            startY++;
            number -= 2;
        }
        if (n % 2 == 1) {
            result[n / 2][n / 2] = n * n;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] result = s.generateMatrix(5);
        System.out.println(Arrays.deepToString(result));
    }
}
