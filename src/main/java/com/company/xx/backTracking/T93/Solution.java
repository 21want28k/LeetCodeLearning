package com.company.xx.backTracking.T93;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int begin) {
        if (path.size() == 4) {
            if (begin == s.length()) {
                StringBuilder builder = new StringBuilder();
                for (String value : path) {
                    builder.append(value).append(".");
                }
                res.add(builder.deleteCharAt(builder.length() - 1).toString());
            }
            return;
        }

        for (int i = begin; i < s.length(); i++) {
            String substring = s.substring(begin, i + 1);
            if (Integer.parseInt(substring) > 255) {
                return;
            }
            if (substring.length() > 1 && substring.startsWith("0")) {
                return;
            }
            path.add(substring);
            dfs(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Solution().restoreIpAddresses("25525511135");
    }
}
