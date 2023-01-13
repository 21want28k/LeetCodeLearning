package com.company.xx.greed.T45;

public class Solution2 {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int index = 0;
        int count = 0;
        while (index < n - 1) {
            int nextScope = index + nums[index];
            int max = nextScope;
            if (nextScope >= n - 1) {
                return count;
            }
            for (int i = index; i <= nextScope; i++) {
                if (nums[i] + i > max) {
                    max = nums[i] + i;
                    index = i;
                }
            }
            if (max != nextScope) {
                count++;
            }
        }
        return count;
    }


    public int jump2(int[] nums) {
        int n = nums.length;
        int end = 0;
        int maxScope = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            maxScope = Math.max(maxScope, nums[i] + i);
            if (i == end){
                end = maxScope;
                count++;
            }
        }
        return count;
    }
}
