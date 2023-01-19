package com.company.xx.greed.T435_Non_overlapping_Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int index = 0;
        int res = 0;
        while (index < n - 1) {
            int left = intervals[index][0];
            int right = intervals[index][1];
            for (int i = index + 1; i < n; i++) {
                if (intervals[i][0] < right && intervals[i][1] > left) {
                    res++;
                    left = Math.max(left, intervals[i][0]);
                    right = Math.min(right, intervals[i][1]);
                    index++;
                } else {
                    index++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        new Solution2().eraseOverlapIntervals(intervals);
    }
}
