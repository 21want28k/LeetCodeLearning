package com.company.xx.string.T344反转字符串;

public class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int low = 0, high = n - 1;
        while (low < high) {
            char temp = s[high];
            s[high] = s[low];
            s[low] = temp;
            low++;
            high--;
        }
    }
}
