package com.company.xx.array.T844比较含退格的字符串;

public class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int sSkip = 0, tSkip = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    sSkip++;
                    i--;
                } else if (sSkip > 0) {
                    sSkip--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    tSkip++;
                    j--;
                } else if (tSkip > 0) {
                    tSkip--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }else {// 如果相等就继续考察
                    i--;
                    j--;
                    continue;
                }
            }
            // 1. i < 0 && j >= 0
            // 2. j < 0 && i >= 0
            // 3. i < 0 && j < 0
            // 1.2 两种情况都是一个有待比较的字符，另一个没有 3是可以的都没有待比较的字符
            if (i >= 0 || j >= 0) {
                return false;
            }
        }
        return true;
    }
}
