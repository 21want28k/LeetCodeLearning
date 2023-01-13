package com.company.xx.greed.T134_Gas_Station;

public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        int start = 0;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (sum < 0) { //  保证到结束的时候，sum一直都是正的。
                sum = 0;
                start = i + 1;
            }
        }
        if (totalSum > 0) {
            return start;
        } else {
            return -1;
        }
    }
}
