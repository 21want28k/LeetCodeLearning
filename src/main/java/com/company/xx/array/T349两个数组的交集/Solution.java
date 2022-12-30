package com.company.xx.array.T349两个数组的交集;

import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int number : nums1) {
            set.add(number);
        }
        for (int number : nums2) {
            if (set.contains(number)) {
                res.add(number);
            }
        }
        int[] a = new int[res.size()];
        int index = 0;
        for (Integer n : res) {
            a[index++] = n;
        }
        return a;
    }
}
