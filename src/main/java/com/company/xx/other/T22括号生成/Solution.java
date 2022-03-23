package com.company.xx.other.T22括号生成;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<String> res = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    int leftNum = 0;
    int rightNum = 0;
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        recursion(0);
        return res;
    }

    public void recursion(int index) {
        if (leftNum < rightNum || leftNum > n || rightNum > n) {
            return;
        }

        if (index == 2 * n) {
            res.add(builder.toString());
        }

        builder.append("{");
        leftNum++;
        recursion(index + 1);
        builder.deleteCharAt(builder.length() - 1);
        leftNum--;

        builder.append("}");
        rightNum++;
        recursion(index + 1);
        builder.deleteCharAt(builder.length() - 1);
        rightNum--;
    }

    public static void main(String[] args) {
        new Solution().generateParenthesis(2);
    }
}
