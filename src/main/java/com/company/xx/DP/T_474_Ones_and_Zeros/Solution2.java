package com.company.xx.DP.T_474_Ones_and_Zeros;

import java.util.Arrays;

public class Solution2 {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[] ones = new int[l];
        int[] zeros = new int[l];

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    zeros[i]++;
                } else {
                    ones[i]++;
                }
            }
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < l; i++) {
            for (int j = m; j >= zeros[i]; j--) {
                for (int k = n; k >= ones[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros[i]][k - ones[i]] + 1);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            int[] zerosOnes = getZerosOnes(strs[i]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }

    public int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }

    public static void main(String[] args) {
        String[] str = {"10", "0001", "111001", "1", "0"};
//        [[0, 0, 0, 0], [0, 1, 1, 1], [0, 1, 1, 1], [0, 1, 1, 1], [0, 1, 2, 2], [0, 1, 2, 2]]
//        [[0, 1, 1, 1], [1, 2, 2, 2], [1, 2, 3, 3], [1, 2, 3, 3], [1, 2, 3, 3], [1, 2, 3, 4]]
        new Solution2().findMaxForm(str, 5, 3);
        new Solution2().findMaxForm2(str, 5, 3);
    }


}
