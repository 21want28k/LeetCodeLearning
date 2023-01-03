package com.company.xx.string.T541反转字符串II;

public class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int number = n / (2 * k);
        int remainder = n % (2 * k);
        for (int i = 0; i < number; i++) {
            int low = i * 2 * k;
            reverse(chars, low, low + k - 1);
        }
        int low = n / (2 * k) * (2 * k);
        if (remainder >= k) {
            reverse(chars, low, low + k-1);
        } else {
            reverse(chars, low, n - 1);
        }
        return new String(chars);
    }

    public void reverse(char[] chars, int low, int high) {
        while (low < high) {
            char temp = chars[high];
            chars[high] = chars[low];
            chars[low] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        new Solution().reverseStr(s, 2);
    }
}
