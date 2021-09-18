package com.company.xx.T3_无重复的最长子串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author xx
 * @date 2021/9/13 18:54
 */
public class Demo {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            HashSet<Character> set = new HashSet<>();
            char left = s.charAt(i);
            set.add(left);
            count++;
            for (int r = i + 1; r < s.length(); r++) {
                char right = s.charAt(r);
                if (set.contains(right)) {
                    break;
                } else {
                    set.add(right);
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {
//        if (s.length() == 0 || s.length() == 1) {
//            return s.length();
//        }
//        int max = 0;
//        int left = 0;
//        int right = 1;
//        HashMap<Character, Integer> map = new HashMap<>();
//        map.put(s.charAt(left), left);
//        while (right < s.length()) {
//            char rightChar = s.charAt(right);
//            if (map.containsKey(rightChar) == false) {
//                map.put(rightChar, right);
//                right++;
//            } else {
//                max = Math.max(max, right - left);
//                int newLeft = map.get(rightChar);
//                left = newLeft + 1;
//                map.remove(rightChar);
//            }
//        }
//        max = Math.max(max, right - left);
//        return max;
        int n = s.length(), result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;
        while (right < n) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                // 更新left的位置,加max是防止回到前面,比如abba，map.get（a）=1，但是left=2，不需要重置left的位置到原来的1
                left = Math.max(map.get(rightChar) + 1, left);
            }
            result = Math.max(result, right - left + 1);
            map.put(rightChar, right);
            right++;
        }
        return result;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring3("abcabcbb"));
        System.out.println(lengthOfLongestSubstring3("abba"));
    }
}