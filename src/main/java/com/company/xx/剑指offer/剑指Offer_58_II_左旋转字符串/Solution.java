package com.company.xx.剑指offer.剑指Offer_58_II_左旋转字符串;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            builder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
