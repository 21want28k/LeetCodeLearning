package com.company.xx.TOP100.T49字母异位词分组;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            ArrayList<String> val = map.getOrDefault(str, new ArrayList<>());
            val.add(s);
            map.put(str, val);
        }
        return new ArrayList<>(map.values());
    }
}
