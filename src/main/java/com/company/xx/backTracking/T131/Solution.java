package com.company.xx.backTracking.T131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        split(s, 0);
        return res;
    }

    public void split(String s, int begin) {
        if (begin == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < s.length(); i++) {
            String b_i = s.substring(begin, i + 1);
            if (judge(b_i)) {
                path.add(b_i);
            } else {
                continue;
            }
            split(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean judge(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().partition("aab");
    }
}
