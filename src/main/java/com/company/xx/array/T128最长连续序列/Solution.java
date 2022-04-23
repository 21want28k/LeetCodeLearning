package com.company.xx.array.T128最长连续序列;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int y = x;
                while (set.contains(y + 1)) {
                    y++;
                }
                maxLength = Math.max(y - x + 1, maxLength);
            }
        }
        return maxLength;
    }
}
