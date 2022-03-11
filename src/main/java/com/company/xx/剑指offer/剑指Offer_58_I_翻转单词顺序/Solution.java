package com.company.xx.剑指offer.剑指Offer_58_I_翻转单词顺序;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();
        int i = s.length() - 1;
        int j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            res.append(s.substring(i + 1, j + 1)).append(' ');
            while (i > 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        new Solution().reverseWords(s);
    }
}
