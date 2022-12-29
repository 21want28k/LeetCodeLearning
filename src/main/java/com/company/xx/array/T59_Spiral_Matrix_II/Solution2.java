package com.company.xx.array.T59_Spiral_Matrix_II;

import javax.swing.plaf.IconUIResource;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Solution2 {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int count = 1;
        int number = n - 1;
        for (int start = 0; start < n / 2; start++) {
            int i = start;
            int j = start;
            while (j < start + number) {
                nums[i][j++] = count++;
            }
            while (i < start + number) {
                nums[i++][j] = count++;
            }
            while (j > start) {
                nums[i][j--] = count++;
            }
            while (i > start) {
                nums[i--][j] = count++;
            }
            number -= 2;
        }
        if (n % 2 == 1) {
            nums[n / 2][n / 2] = n * n;
        }
        return nums;
    }

    public int[][] generateMatrix2(int n) {
        int[][] nums = new int[n][n];
        int count = 1;
        int number = n - 1;
        int startX = 0, startY = 0;
        while (number > 0) {
            int i = startX;
            int j = startY;
            while (j < startY + number) {
                nums[i][j++] = count++;
            }
//            while (j < j+ number) {
//                nums[i][j++] = count++;
//            }
            while (i < startX + number) {
                nums[i++][j] = count++;
            }
            while (j > startY) {
                nums[i][j--] = count++;
            }
            while (i > startX) {
                nums[i--][j] = count++;
            }
            startX++;
            startY++;
            number -= 2;
        }
        if (n % 2 == 1) {
            nums[n / 2][n / 2] = n * n;
        }
        return nums;
    }

    public static void main(String[] args) {
        new Solution2().generateMatrix(4);
        System.out.println(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8).length);
    }
}
