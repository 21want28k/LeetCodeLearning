package com.company.xx.TOP100.T215;

import java.util.Random;

class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSort(nums, 0, n - 1, k);
    }

    public int quickSort(int[] nums, int left, int right, int k) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot == k - 1) {
                return nums[pivot];
            } else if (pivot < k - 1) {
                return quickSort(nums, pivot + 1, right, k);
            } else {
                return quickSort(nums, left, pivot - 1, k);
            }
        }
        return -1;
    }

    public int partition(int[] nums, int left, int right) {
        int pivotIndex = random.nextInt(right - left + 1) + left;
        int pivot = nums[pivotIndex];
        nums[pivotIndex] = nums[left];
        while (left < right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(new Solution().findKthLargest(nums,4));
    }
}
