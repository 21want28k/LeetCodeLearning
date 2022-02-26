package com.company.xx.greed.T452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static int findMinArrowBurstBalloons(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        int i = 0;
        int arrow = 0;
        int lap = 0;
        int[] lapArea = new int[2];
        while (i < points.length) {
            // 包含重叠部分
            if (lap > 0) {
                // 重叠部分和新的部分再次重叠
                if (lapArea[0] <= points[i][0] && points[i][0] <= lapArea[1]) {
                    lap++;
                    lapArea[0] = Math.max(lapArea[0], points[i][0]);
                    lapArea[1] = Math.min(lapArea[1], points[i][1]);
                } else {
                    arrow++;
                    // 射一箭解决上面的重叠部分
                    lap = 0;
                    i--;
                }
            } else {
                if (i + 1 < points.length && points[i][1] >= points[i + 1][0] && points[i + 1][0] >= points[i][0]) {
                    lap++;
                    lapArea[0] = Math.max(points[i][0], points[i + 1][0]);
                    lapArea[1] = Math.min(points[i][1], points[i + 1][1]);
                    // 两个合并成一个继续下一轮，需要++，算上最后的i++，实际上直接到了i+2这个位置。
                    i++;
                } else {
                    // 未出现重叠部分，得单独射一箭
                    arrow++;
                }
            }
            i++;
        }
        // 出现重叠了，但是后面没有气球了，射一箭。
        if (lap > 0) {
            arrow++;
        }
        return arrow;
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // [10,16],[2,8],[1,6],[7,12]
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
//        int[][] points = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(findMinArrowShots(points));
    }
}
