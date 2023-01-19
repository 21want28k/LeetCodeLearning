package com.company.xx.greed.T452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {

    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int index = 0;
        int number = 0;
        while (index < n) {
            int left = points[index][0];
            int right = points[index][1];
            for (int i = index; i < n; i++) {
                if (points[i][0] <= right && points[i][0] >= left) {
                    index++;
                    left = Math.max(left, points[i][0]);
                    right = Math.min(right, points[i][1]);
                } else {
                    break;
                }
            }
            number++;
        }
        return number;
    }


    public static void main(String[] args) {
        int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        new Solution2().findMinArrowShots(points);
    }
}
