package com.company.xx.greed.T763_Partition_Labels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2 {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[][] intervals = new int[26][2];
//        Arrays.fill(intervals, new int[]{-1, -1});
        for (int i = 0; i < 26; i++) {
            intervals[i][0] = -1;
            intervals[i][1] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (intervals[a - 'a'][0] == -1) {
                intervals[a - 'a'][0] = i;
            }
            intervals[a - 'a'][1] = i;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int left = -1;
        int right = -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (intervals[i][0] != -1) {
                if (left == -1 && right == -1) {
                    left = intervals[i][0];
                    right = intervals[i][1];
                } else if (intervals[i][0] > right) {
                    list.add(right - left + 1);
                    left = intervals[i][0];
                    right = intervals[i][1];
                } else {
                    right = Math.max(right, intervals[i][1]);
                }
            }
        }
        list.add(right - left + 1);
        return list;
    }

    public List<Integer> partitionLabels2(String s) {
        int[] last = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int end = -1;
        int start = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(new Solution2().partitionLabels(s));
    }
}
