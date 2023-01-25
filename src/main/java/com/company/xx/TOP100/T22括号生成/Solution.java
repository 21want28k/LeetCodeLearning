package com.company.xx.TOP100.T22括号生成;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    StringBuilder one = new StringBuilder();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n);
        return res;
    }

    public void dfs(int left, int right, int max) {
        if (one.length() == max * 2) {
            res.add(one.toString());
            return;
        }
        if (right < left) {
            one.append(")");
            dfs(left, right + 1, max);
            one.deleteCharAt(one.length() - 1);
        }
        if (left < max) {
            one.append("(");
            dfs(left + 1, right, max);
            one.deleteCharAt(one.length() - 1);
        }
    }
}
