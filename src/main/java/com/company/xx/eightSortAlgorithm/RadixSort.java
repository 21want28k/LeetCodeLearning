package com.company.xx.eightSortAlgorithm;

import java.util.Arrays;

public class RadixSort {

    public void sort(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(0);
        int n = 1;
        int[][] bucket = new int[10][nums.length];

        while (n < max) {
            int[] counts = new int[10]; //  记录每个桶里面有多少个数字,也方便用来进行遍历

            // 放进桶里面
            for (int num : nums) {
                int index = (num / n) % 10; // 哪一个桶
                bucket[index][counts[index]] = num;
                counts[index]++;
            }

            int k = 0;

            // 从桶里面取出重新组成数组,i用来遍历桶，j用来遍历桶里面的每一个数字
            for (int i = 0; i < 10; i++) {
                if (counts[i] != 0) {
                    for (int j = 0; j < counts[i]; j++) {
                        nums[k++] = bucket[i][j];
                    }
                }
//                // 将计数器置为0，以便下一次的排序
//                counts[i] = 0;
            }
            System.out.println(Arrays.toString(nums));
            n *= 10;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 6, 3, 8, 33, 27, 66, 9, 7, 88};
        new RadixSort().sort(nums);
    }
}
