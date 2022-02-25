package com.company.xx.greed.T738_Monotone_Increasing_Digits;

import java.util.Arrays;

public class Solution {
    public static int getMaxNumber(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        for (int i = n - 1; i > 0; i--) {
            if (chars[i - 1] > chars[i]) {
                chars[i - 1]--;
                Arrays.fill(chars, i, n, '9');
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static int getMaxNumber2(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int start = Integer.MAX_VALUE;
        for (int i = n - 1; i > 0; i--) {
            if (chars[i - 1] > chars[i]) {
                chars[i - 1]--;
                start = i; // 从[i:n-1]都得变成9
            }
        }

        if (start != Integer.MAX_VALUE) {
            Arrays.fill(chars, start, n, '9');
        }
        return Integer.parseInt(new String(chars));
    }

    public static int monotoneIncreasingDigits(int n) {
        char[] strN = Integer.toString(n).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(852));
    }
}
