package com.company.xx.DP_多重背包;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static int getMaxValue(int[] nums, int[] weight, int[] values, int bagWeight) {
        int n = weight.length;
        int[] dp = new int[bagWeight + 1];

        for (int i = 0; i < n; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                for (int k = 0; k <= nums[i]; k++) {
                    if (j >= weight[i] * k) {
                        dp[j] = Math.max(dp[j], dp[j - weight[i] * k] + k * values[i]);
                    }
                }
            }
        }
        return dp[bagWeight];
    }

    public static int getMaxValue2(int[] nums, int[] weight, int[] values, int bagWeight) {
        int n = weight.length;
        int[] dp = new int[bagWeight + 1];
        List<Integer> newWeight = new ArrayList<>();
        List<Integer> newValues = new ArrayList<>();

        // do the loop to item in the mums
        for (int i = 0; i < n; i++) {
            // 1, 2, 4... 一直到不大于nums[i]的最大二进制数
            for (int o = 1; o <= nums[i]; o *= 2) {
                newWeight.add(weight[i] * o);
                newValues.add(values[i] * o);
                nums[i] -= o;
            }
            // handle the remainder
            if (nums[i] > 0) {
                newWeight.add(weight[i] * nums[i]);
                newValues.add(values[i] * nums[i]);
            }
        }

        System.out.println(newWeight);

        for (int i = 0; i < newWeight.size(); i++) {
            for (int j = bagWeight; j >= newWeight.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - newWeight.get(i)] + newValues.get(i));
            }
        }

        return dp[bagWeight];
    }

    public static int getMaxValue3(int[] nums, int[] weight, int[] values, int bagWeight) {
        List<Integer> newWeight = new ArrayList<>();
        List<Integer> newValue = new ArrayList<>();
        int n = weight.length;
        int[] dp = new int[bagWeight + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums[i]; j++) {
                newWeight.add(weight[i]);
                newValue.add(values[i]);
            }
        }

        for (int i = 0; i < newWeight.size(); i++) {
            for (int j = bagWeight; j >= newWeight.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - newWeight.get(i)] + newValue.get(i));
            }
        }
        return dp[bagWeight];
    }

    public static void main(String[] args) {
//        int bagWeight = 5;
//        int[] weight = new int[]{1, 2, 3, 4};
//        int[] values = new int[]{2, 4, 4, 5};
//        int[] nums = new int[]{3, 1, 3, 2};

        int bagWeight = 10;
        int[] weight = new int[]{3, 4, 2, 5};
        int[] values = new int[]{2, 3, 2, 3};
        int[] nums = new int[]{2, 2, 1, 4}; // 8
//        int bagWeight = 1000;
//        int[] weight = new int[]{80, 40, 30, 40, 20};
//        int[] values = new int[]{20, 50, 50, 30, 20};
//        int[] nums = new int[]{4, 9, 7, 6, 1}; // 1040
        System.out.println(getMaxValue3(nums, weight, values, bagWeight));
    }
}