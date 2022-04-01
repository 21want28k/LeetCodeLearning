package com.company.xx.other.T49字母异位词分组;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> l = map.getOrDefault(key, new ArrayList<>());
            l.add(str);
            map.put(key, l);
        }
        return new ArrayList<>(map.values());
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    builder.append(i + 'a');
                    builder.append(counts[i]);
                }
            }
            List<String> list = map.getOrDefault(builder.toString(), new ArrayList<>());
            list.add(str);
            map.put(builder.toString(), list);
        }
        return new ArrayList<>(map.values());
    }

}
