package com.company.xx.剑指offer.剑指Offer_04_二维数组中的查找;

public class Solution {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean find = false;
        int n = matrix.length; // 行
        if (n == 0) {
            return find;
        }
        int m = matrix[0].length; // 列
        int x = 0;
        int y = m - 1;

        while (x < n && y >= 0) {
            if (matrix[x][y] < target) {
                x++;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                find = true;
                break;
            }
        }
        return find;
    }

    public static void main(String[] args) {
        String s = "[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]";
        String s2 = s.replaceAll("\\[", "{");
        String s3 = s2.replaceAll("]", "}");
        System.out.println(s3);
//        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] matrix = new int[][]{{-5}};
        findNumberIn2DArray(matrix, -5);
    }
}