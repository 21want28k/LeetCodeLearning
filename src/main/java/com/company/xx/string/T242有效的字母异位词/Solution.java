package com.company.xx.string.T242有效的字母异位词;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        if (smap.size() != tmap.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : smap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (tmap.get(key) == null || !tmap.get(key).equals(value)) {
                return false;
            }
        }
        return true;
    }
}
