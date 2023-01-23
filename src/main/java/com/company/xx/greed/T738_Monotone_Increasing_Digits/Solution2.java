package com.company.xx.greed.T738_Monotone_Increasing_Digits;

import java.util.Arrays;

public class Solution2 {
    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        n = chars.length;
        int start = n;
        for (int i = n - 1; i > 0; i--) {
            if (chars[i] < chars[i - 1]) {
                start = i - 1;
                chars[start]--;
            }
        }
        if (start != n) {
            Arrays.fill(chars, start, n, '9');
        }
        return Integer.parseInt(new String(chars));
    }
}
