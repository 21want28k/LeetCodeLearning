package com.company.xx.DP.T_474_Ones_and_Zeros;

import java.util.Arrays;

public class Solution {

    public static int[] getOnesOrZeros(String[] strings, char zOro) {
        int n = strings.length;
        int[] ones = new int[n];
        for (int j = 0; j < n; j++) {
            String s = strings[j];
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == zOro) {
                    ones[j]++;
                }
            }
        }
        return ones;
    }

    // m是0的个数，n是1的个数
    public static int findMaxForm(String[] strs, int m, int n) {
        int[] zeros = getOnesOrZeros(strs, '0');
        int[] ones = getOnesOrZeros(strs, '1');
        int a = strs.length;
//        int m = zeros.length;
//        int n = ones.length;

        int[][][] dp = new int[a + 1][n + 1][m + 1];

        for (int i = 1; i < a + 1; i++) {
            int one = ones[i - 1];
            int zero = zeros[i - 1];
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < m + 1; k++) {
                    if (j >= one && k >= zero) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - one][k - zero] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[a][n][m];
    }

    public static int findMaxForm2(String[] strs, int m, int n) {
        int[] zeros = getOnesOrZeros(strs, '0');
        int[] ones = getOnesOrZeros(strs, '1');
        int a = strs.length;
//        int m = zeros.length;
//        int n = ones.length;

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < a; i++) {
            int one = ones[i];
            int zero = zeros[i];
            for (int j = n; j >= one; j--) {
                for (int k = m; k >= zero; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - one][k - zero] + 1);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][m];
    }

    // n是1的个数，m是0的个数s
    public static int findMaxForm3(String[] strs, int m, int n) {
        int a = strs.length;
        int[][] dp = new int[n + 1][m + 1];
        for (String s : strs) {
            int one = 0;
            int zero = 0;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            for (int j = n; j >= one; j--) {
                for (int k = m; k >= zero; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - one][k - zero] + 1);
                }
            }
        }
        return dp[n][m];
    }


    public static void main(String[] args) {
//        String[] strings = new String[]{"10", "0001", "111001", "1", "0"};
        String[] strings = new String[]{"10", "0", "1"};
//        int[] ones = getOnesOrZeros(strings, '1');
//        int[] zeros = getOnesOrZeros(strings, '0');
//        System.out.println(Arrays.toString(zeros));
        System.out.println(findMaxForm3(strings, 1, 1));
    }
}