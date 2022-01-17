package com.company.xx.剑指offer.剑指Offer_29_顺时针打印矩阵;

import com.company.xx.utils.MyStringUtils;

import java.util.Arrays;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        // n * m
        int n = matrix.length;
        if (n == 0) {
            return new int[]{};
        }
        int m = matrix[0].length;
        int number_i = m - 1; // 第一次行遍历多少个
        int number_j = n - 1; // 第一次列遍历多少个
        int[] result = new int[n * m];
        int index = 0;
        int startRow = 0;
        int startColumn = 0;
        while (number_i >= 0 && number_j >= 0) {
            int row = startRow; // 代表矩阵的行
            int column = startColumn; // 代表矩阵的列
            // 只剩一列的情况
            if (number_i == 0 && number_j > 0) {
                for (; row <= startRow + number_j; row++) {
                    result[index++] = matrix[row][column];

                }
                number_j = -1;
                // 只剩一行的情况
            } else if (number_i > 0 && number_j == 0) {
                for (; column <= startColumn + number_i; column++) {
                    result[index++] = matrix[row][column];
                }
                number_i = -1;
            } else if (number_i > 0 && number_j > 0) {
                for (; column < startColumn + number_i; column++) {
                    result[index++] = matrix[row][column];
                }
                for (; row < startRow + number_j; row++) {
                    result[index++] = matrix[row][column];
                }
                for (; column > startColumn; column--) {
                    result[index++] = matrix[row][column];
                }
                for (; row > startRow; row--) {
                    result[index++] = matrix[row][column];
                }
                number_i -= 2;
                number_j -= 2;
                startRow++;
                startColumn++;
            } else {
                result[index] = matrix[n / 2][n / 2];
                break;
            }

        }
//        if (n == m && (n & 1) == 1) {
//            result[index] = matrix[n / 2][n / 2];
//        }
        return result;
    }

    public int[] spiralOrder2(int[][] matrix) {
        // n * m
        int n = matrix.length;
        if (n == 0) {
            return new int[]{};
        }
        int m = matrix[0].length;
        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;
        int index = 0;
        int[] result = new int[n * m];
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                result[index++] = matrix[top][i];
            }
            for (int i = top; i < bottom; i++) {
                result[index++] = matrix[i][right];
            }
            for (int i = right; i > left; i--) {
                result[index++] = matrix[bottom][i];
            }
            for (int i = bottom; i > top; i--) {
                result[index++] = matrix[i][left];
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        if (top == bottom) {
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
        } else if (left == right) {
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][left];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "[[1,2,3,4,5,6,7,8,9,10],[11,12,13,14,15,16,17,18,19,20]]";
        System.out.println(MyStringUtils.replaceBracketsToBraces(s));
        int[][] matrix = new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.spiralOrder(matrix)));
    }
}
