package com.company.xx.剑指offer.剑指Offer_05_替换空格;

public class Solution {
    public String replaceSpace(String s) {
        String replaceString = "%20";
        int n = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                builder.append(replaceString);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
