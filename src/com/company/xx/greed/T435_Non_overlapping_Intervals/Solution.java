package com.company.xx.greed.T435_Non_overlapping_Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static int removeMinIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return n - max;
    }

    public static int removeMinIntervals2(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        System.out.println(Arrays.deepToString(intervals));
        int ans = 1;
        int pos = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= pos) {
                pos = intervals[i][1];
                ans++;
            }
        }

        return n - ans;
    }

    public static void main(String[] args) {
        // [1,2],[2,3],[3,4],[1,3]
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(removeMinIntervals2(intervals));
    }
}