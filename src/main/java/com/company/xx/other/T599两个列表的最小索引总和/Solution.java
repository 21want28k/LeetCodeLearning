package com.company.xx.other.T599两个列表的最小索引总和;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int minIndex = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> res = new ArrayList<>();
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                Integer index = map.get(list2[j]);
                if (index + j < minIndex) {
                    res.clear();
                    res.add(list2[j]);
                    minIndex = index + j;
                } else if (index + j == minIndex) {
                    res.add(list2[j]);
                }
            }
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        new Solution().findRestaurant(list1, list2);
    }
}