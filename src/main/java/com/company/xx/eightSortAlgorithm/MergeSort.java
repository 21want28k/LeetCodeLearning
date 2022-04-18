package com.company.xx.eightSortAlgorithm;

public class MergeSort {
    public int[] merge(int[] a, int[] b) {
        int[] temp = new int[a.length + b.length];
        int index_temp = 0;
        int indexA = 0;
        int indexB = 0;
        while (indexA < a.length && indexB < b.length) {
            if (a[indexA] < b[indexB]) {
                temp[index_temp++] = a[indexA++];
            } else {
                temp[index_temp++] = b[indexB++];
            }
        }
        while (indexA < a.length) {
            temp[index_temp++] = a[indexA++];
        }

        while (indexB < b.length) {
            temp[index_temp++] = b[indexB++];
        }
        return temp;
    }


    public void merge2(int[] nums, int low, int mid, int high) {
        // 需要merge的两个部分一个是[low, mid] 一个是 [mid+1, high]
        int[] temp = new int[nums.length];
        int indexA = low, indexB = mid + 1, indexTemp = low;
        while (indexA <= mid && indexB <= high) {
            if (nums[indexA] > nums[indexB]) {
                temp[indexTemp++] = nums[indexB++];
            } else {
                temp[indexTemp++] = nums[indexA++];
            }
        }

        while (indexA <= mid) {
            temp[indexTemp++] = nums[indexA++];
        }
        while (indexB <= high) {
            temp[indexTemp++] = nums[indexB++];
        }
        // 将排序之后的数组部分进行回填到nums中，那为什么不在nums上直接操作呢？因为直接在nums上，之前的数字会丢失的
        for (int i = low; i < indexTemp; i++) {
            nums[i] = temp[i];
        }
    }

    public void mergeSort(int[] nums, int low, int high) {
        // 同样low >=high的时候，要么是一个元素要么是空的，这个时候不需要继续执行了。
        if (low < high) {
            int mid = low + ((high - low) >> 1);
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge2(nums, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};
        int[] c = new MergeSort().merge(a, b);


        int[] nums = {3, 6, 4, 7, 5, 2};
        new MergeSort().mergeSort(nums, 0, nums.length - 1);
    }
}
