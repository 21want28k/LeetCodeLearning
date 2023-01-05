package com.company.xx.array.T347_Top_K_Frequent_Elements;

import java.util.*;

public class Solution2 {
    /**
     * 复习的大根堆排序
     */
    static class MaxHeap {
        int[] heap;

        public MaxHeap(int[] heap) {
            this.heap = heap;
        }

        /**
         * 向一直下调整
         *
         * @param i   调整的索引位置
         * @param end 调整的范围
         */
        public void adjustFromUptoDown(int i, int end) {
            int maxChild = -1;
            int leftChildIndex = getLeftChild(i);
            int rightChildIndex = getRightChild(i);
            if (leftChildIndex > end) {
                return;
            }
            if (rightChildIndex > end) {
                maxChild = leftChildIndex;
            } else if (heap[leftChildIndex] > heap[rightChildIndex]) {
                maxChild = leftChildIndex;
            } else {
                maxChild = rightChildIndex;
            }
            if (heap[i] > heap[maxChild]) {
                return;
            }
            swap(heap, maxChild, i);
            adjustFromUptoDown(maxChild, end);
        }

        /**
         * 向上一直调整
         *
         * @param i 索引位置
         */
        public void adjustFromDownToUp(int i) {
            int fatherIndex = getFather(i);
            if (fatherIndex <= 0) {
                return;
            }
            if (heap[fatherIndex] > heap[i]) {
                return;
            }
            swap(heap, fatherIndex, i);
            adjustFromDownToUp(fatherIndex);
        }

        public void build() {
            int n = heap.length;
            for (int i = n / 2 - 1; i >= 0; i--) {
                adjustFromUptoDown(i, n - 1);
            }
        }

        public void sort() {
            build();
            for (int i = heap.length - 1; i > 0; i--) {
                swap(heap, 0, i);
                adjustFromUptoDown(0, i - 1);
            }
        }

        private void swap(int[] heap, int a, int b) {
            int temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;
        }

        public int getLeftChild(int father) {
            return 2 * father + 1;
        }

        public int getRightChild(int father) {
            return 2 * father + 2;
        }

        public int getFather(int i) {
            return (i - 1) / 2;
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new Integer[]{entry.getKey(), entry.getValue()});
        }
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heap = {3, 4, 7, 8, 10, 13, 1, 2, 5};
        MaxHeap maxHeap = new MaxHeap(heap);
        maxHeap.sort();

        int[] nums = {1, 1, 1, 2, 2, 3};
        new Solution2().topKFrequent(nums, 2);
    }

}
