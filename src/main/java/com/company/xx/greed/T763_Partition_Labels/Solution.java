package com.company.xx.greed.T763_Partition_Labels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<Integer> partitionLabels(String s) {
        int n = s.length();

        int[][] record = new int[26][2]; // [start, end]

        for (int i = 0; i < record.length; i++) {
            record[i][0] = -1;
        }
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (record[index][0] == -1) {
                record[index][0] = i;
            }
            record[index][1] = i;
        }
        System.out.println(Arrays.deepToString(record));

        List<Integer> result = new ArrayList<>();
        int index = s.charAt(0) - 'a';
        int left = record[index][0];
        int right = record[index][1];

        for (char c : s.toCharArray()) {
            int j = c - 'a';
            if (record[j][1] > right) {
                if (record[j][0] > right) {
                    result.add(right - left + 1);
                    left = record[j][0];
                } else {
                    left = Math.min(record[j][0], left);
                }
                right = record[j][1];
            } else {
                left = Math.min(record[j][0], left);
            }
        }
        result.add(right - left + 1);
        return result;
    }

    public static List<Integer> partitionLabels2(String s) {
        int n = s.length();
        int[] last = new int[26]; // 记录字符出现的最后一个位置

        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            last[index] = i;
        }

        List<Integer> list = new ArrayList<>();
        int start = 0, end = 0;
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
        String s = new String("vhaagbqkaq");
        System.out.println(partitionLabels(s));
    }
}