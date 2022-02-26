package com.company.xx.剑指offer.剑指Offer_51_数组中的逆序对;

public class Solution {
    int[] temp;
    int sum;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        this.temp = new int[n];
        mergeSort(0, n - 1, nums);
        return sum;
    }

    public void mergeSort(int low, int high, int[] nums) {
        if (low < high) {
            // 这边也容易写错，位移符号的优先级小
            int mid = low + ((high - low) >> 1);
            mergeSort(low, mid, nums);
            mergeSort(mid + 1, high, nums);
            merge(nums, low, mid, high);
        }
    }

    public void merge(int[] nums, int low, int mid, int high) {
        int lowIndex = low;
        int highIndex = mid + 1; // 两个区间[low, mid];[mid+1, high]
        int tempIndex = low; // 这是一个重要的地方，很容易写成0出错。
        while (lowIndex <= mid && highIndex <= high) {
            if (nums[lowIndex] <= nums[highIndex]) {
                temp[tempIndex++] = nums[lowIndex++];
            } else {
                sum += (mid - lowIndex + 1);
                temp[tempIndex++] = nums[highIndex++];
            }
        }
        while (lowIndex <= mid) {
            temp[tempIndex++] = nums[lowIndex++];
        }
        while (highIndex <= high) {
            temp[tempIndex++] = nums[highIndex++];
        }
        // temp[low:high]拷贝回数组
        for (int i = low; i <= high; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 2, 1};
        Solution s = new Solution();
        System.out.println(s.reversePairs(nums));
    }
}
