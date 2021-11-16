package com.company.xx.DP.T647_Palindromic_Substrings;

import java.util.Arrays;

public class solution {
    public static int countSubstrings(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int sum = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i > 1) {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            sum++;
                        }
                    } else {
                        dp[i][j] = true;
                        sum++;
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return sum;
    }

    public static int countSubstrings2(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i <= n; i++) {
            int l = i;
            int r = l;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                sum++;
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                sum++;
                l--;
                r++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
}
