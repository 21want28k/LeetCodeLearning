package com.company.xx.剑指offer.剑指Offer_38_字符串的排列;

import java.util.*;

/**
 * 关键的两个问题
 * 1. 如何得到不同的排列，通过交换得到
 * 2. 如何去重，每个位置上的字符选择时，记住已经选择过的数字。
 */
public class Solution {
    List<String> result = new ArrayList<>();
    // store every arrangement
    char[] items;

    public String[] permutation(String s) {
        items = s.toCharArray();
        dfs(0);
        return result.toArray(new String[0]);
    }

    public void dfs(int x) {
        // There is only has one choice at the last position.
        if (x == items.length - 1) {
            result.add(String.valueOf(items));
            return;
        }
        // The set records every choice of the position. e.g. If 'a' has been chosen, set will be ['a'].
        // So to avoid the duplicate value, another char 'a' won't be chosen.
        Set<Character> set = new HashSet<>();
        for (int i = x; i < items.length; i++) {
            if (set.contains(items[i])) {
                continue;
            }
            set.add(items[i]);
            // swap in order to get another arrangement e.g. x=0,i=1 [a,b] swap(x,i) we will get [b,a]
            swap(x, i);
            dfs(x + 1);
            // backtrack to recover items to try another arrangement
            swap(x, i);
        }
    }

    public void swap(int a, int b) {
        char temp = items[a];
        items[a] = items[b];
        items[b] = temp;
    }

    public static void main(String[] args) {
        String s = "abbc";
        new Solution().permutation(s);
    }
}
