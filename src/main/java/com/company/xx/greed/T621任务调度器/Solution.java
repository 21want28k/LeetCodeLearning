package com.company.xx.greed.T621任务调度器;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        int max = 0;
        int maxCount = 1;
        for (char c : tasks) {
            counts[c - 'A']++;
        }
        for (int count : counts) {
            if (count > max) {
                max = count;
                maxCount = 1;
            } else if (count == max) {
                maxCount++;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
    }
}
