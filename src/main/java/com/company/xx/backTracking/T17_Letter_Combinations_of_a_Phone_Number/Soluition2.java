package com.company.xx.backTracking.T17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Soluition2 {
    List<String> res = new ArrayList<>();
    StringBuilder builder = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
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
        int n = digits.length(); // 选几个数
        dfs(n, digits, 0, map);
        return res;
    }

    public void dfs(int n, String digits, int index, Map<Character, String> map) {
        if (index == n) {
            res.add(builder.toString());
            return;
        }
        String s = map.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i));
            dfs(n, digits, index + 1, map);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        new Soluition2().letterCombinations("23");
    }
}
