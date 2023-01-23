package com.company.xx.greed.T56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > right) {
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                right = Math.max(intervals[i][1], right);
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[0][]);
    }
}
