package com.company.xx.greed.T134_Gas_Station;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] remnant = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            remnant[i] = gas[i] - cost[i];
            sum += remnant[i];
        }

        if (sum < 0) {
            return -1;
        }

        int totalRemnant = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            totalRemnant += remnant[i];
            if (totalRemnant < 0) {
                start = i + 1;
                totalRemnant = 0;
            }
        }
        return start;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;

        int curTotalRemnant = 0; // 当前循环内的总剩余
        int start = 0;
        for (int i = 0; i < n; i++) {
            int remnant = gas[i] - cost[i];
            sum += remnant;
            curTotalRemnant += remnant;
            if (curTotalRemnant < 0) {
                start = i + 1;
                curTotalRemnant = 0;
            }
        }

        if (sum < 0) {
            return -1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};

        Solution s = new Solution();
        System.out.println(s.canCompleteCircuit(gas, cost));
    }
}
