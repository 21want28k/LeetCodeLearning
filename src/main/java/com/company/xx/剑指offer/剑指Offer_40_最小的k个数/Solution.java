package com.company.xx.剑指offer.剑指Offer_40_最小的k个数;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int n = arr.length; // n>= k
        // 默认是小根堆，调整为大根堆
        Queue<Integer> heap = new PriorityQueue<>(k, ((o1, o2) -> o2 - o1));
        int index;
        for (index = 0; index < k; index++) {
            heap.offer(arr[index]);
        }
        for (index = k; index < n; index++) {
            int maxOfHeap = heap.element();
            if (arr[index] < maxOfHeap) {
                heap.poll();
                heap.offer(arr[index]);
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }
        return result;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // n>= k
        int n = arr.length;
        quickSelect(arr, k - 1, 0, n - 1);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public void quickSelect(int[] arr, int k, int low, int high) {
        int pivot = arr[low];
        int index = partition(arr, low, high, pivot);

        if (index > k) {
            quickSelect(arr, k, low, index - 1);
        }
        if (index < k) {
            quickSelect(arr, k, index + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high, int pivot) {
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    // arr = [3,2,1], k = 2
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 2, 3, 2, 1, 1, 2, 0, 4};
        int k = 10;
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.getLeastNumbers2(arr, k)));
    }
}
