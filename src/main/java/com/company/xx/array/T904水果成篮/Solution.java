package com.company.xx.array.T904水果成篮;

import java.util.*;

public class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int low = 0, high = 0;
        int max = -1;

        Map<Integer, Integer> map = new HashMap<>();
        while (high < n) {
            map.put(fruits[high], map.getOrDefault(fruits[high], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[low], map.get(fruits[low]) - 1);
                if (map.get(fruits[low]) == 0) {
                    map.remove(fruits[low]);
                }
                low++;
            }
            max = Math.max(max, high - low + 1);
            high++;
        }
        return max;
    }

    public int totalFruit2(int[] fruits) {
        int n = fruits.length;
        int high = 0;
        int max = -1;

        Set<Integer> set = new HashSet<>();
        int low = 0;
        while (high < n) {
            set.add(fruits[high]);
            if (set.size() > 2) {
                low = high - 1;
                while (fruits[low - 1] == fruits[low]) {
                    low--;
                }
                set.remove(fruits[low - 1]);
            }
            max = Math.max(max, high - low + 1);
            high++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] f = {1, 2, 3, 2, 2};
        new Solution().totalFruit2(f);
    }
}
