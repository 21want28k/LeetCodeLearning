package com.company.xx.greed.T409;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            Integer value = map.get(c);
            if (value != null) {
                value++;
                map.put(c, value);
            } else {
                map.put(c, 1);
            }
        }
        Collection<Integer> values = map.values();
        int sum = 0;
        boolean flag = false;
        for (Integer v : values) {
            if (v % 2 == 1) {
                flag = true;
            }
            sum += v / 2 * 2;
        }
        if (flag) {
            sum++;
        }

        return sum;
    }

    public static int longestPalindrome2(String s) {
        int n = s.length();
        int[] count = new int[128]; // 0~172

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int sum = 0;
        for (int i : count) {
            sum += i / 2 * 2;
            if (i % 2 == 1 && sum % 2 == 0) {
                sum++;
            }
        }
        return sum;
    }

    public static int longestPalindrome3(String s) {
        int n = s.length();
        int[] count = new int[128]; // 0~172

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int countJI = 0;
        for (int c : count) {
            if (c % 2 == 1) {
                countJI++;
            }
        }
        return countJI == 0 ? n : (n - countJI + 1);
    }

    public static void main(String[] args) {
        String s = "ccc";
        System.out.println(longestPalindrome3(s));
    }
}
