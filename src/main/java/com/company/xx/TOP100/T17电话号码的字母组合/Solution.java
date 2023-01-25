package com.company.xx.TOP100.T17电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    List<String> list = new ArrayList<>();
    StringBuilder one = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return list;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(0, map, digits);
        return list;
    }

    public void dfs(int startIndex, Map<Character, String> map, String digits) {
        if (one.length() == digits.length()) {
            list.add(one.toString());
            return;
        }
        String s = map.get(digits.charAt(startIndex));
        for (int i = 0; i < s.length(); i++) {
            one.append(s.charAt(i));
            dfs(startIndex + 1, map, digits);
            one.deleteCharAt(one.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        new Solution().letterCombinations(digits);
    }
}
