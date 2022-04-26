package com.company.xx.array.T240_搜索二维矩阵_II;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int column = n - 1;
        while (row <= m && column >= 0) {
            if (matrix[row][column] > target) {
                column--;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
