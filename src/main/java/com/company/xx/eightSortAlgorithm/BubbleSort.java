package com.company.xx.eightSortAlgorithm;

public class BubbleSort {

    public static void sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    flag = false;
                }
            }
            if (flag){
                return;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 7, 9, 10};
        sort(nums);
    }
}