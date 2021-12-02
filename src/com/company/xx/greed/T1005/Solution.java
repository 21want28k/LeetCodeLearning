package com.company.xx.greed.T1005;

import java.util.Arrays;

public class Solution {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (k > 0) {
                if (nums[i] < 0) {
                    sum += -nums[i];
                    min = Math.min(min, -nums[i]);
                    k--;
                } else {
                    if (k % 2 == 1) {
                        min = Math.min(min, nums[i]);
                        sum += -2 * min;
                    }
                    sum += nums[i];
                    k = 0;
                }
            } else {
                sum += nums[i];
            }
        }

        if (k > 0 && k % 2 == 1) {
            sum += -2 * min;
        }
        return sum;
    }

    public static int largestSumAfterKNegations2(int[] A, int K) {
        int[] number = new int[201];//-100 <= A[i] <= 100,这个范围的大小是201
        for (int t : A) {
            number[t + 100]++;//将[-100,100]映射到[0,200]上
        }
        int i = 0;
        while (K > 0) {
            while (number[i] == 0)//找到A[]中最小的数字
                i++;
            number[i]--;//此数字个数-1
            number[200 - i]++;//其相反数个数+1
            if (i > 100) {//若原最小数索引>100,则新的最小数索引应为200-i.(索引即number[]数组的下标)
                i = 200 - i;
            }
            K--;
        }
        int sum = 0;
        for (int j = i; j < number.length; j++) {//遍历number[]求和
            sum += (j - 100) * number[j];//j-100是数字大小,number[j]是该数字出现次数.
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -2, -3};
        int k = 4;
        System.out.println(largestSumAfterKNegations(nums, k));
    }
}
