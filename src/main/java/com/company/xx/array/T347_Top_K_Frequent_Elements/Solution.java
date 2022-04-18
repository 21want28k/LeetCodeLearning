package com.company.xx.array.T347_Top_K_Frequent_Elements;

import java.util.*;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer frequency = map.getOrDefault(num, 0);
            frequency++;
            map.put(num, frequency);
        }


        // int[] int[0]代表数，int[1]代表频率
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer frequency = entry.getValue();
            if (heap.size() == k) {
                if (frequency > heap.peek()[1]) {
                    heap.remove();
                    heap.add(new int[]{num, frequency});
                }
            } else {
                heap.add(new int[]{num, frequency});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[0];
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // int[] int[0]代表数，int[1]代表频率
        for (int num : nums) {
            Integer frequency = map.getOrDefault(num, 0);
            frequency++;
            map.put(num, frequency);
        }
        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer frequency = entry.getValue();
            values.add(new int[]{num, frequency});
        }
        int[] res = new int[k];
        quickSort(values, 0, values.size() - 1, k, 0, res);
        return res;
    }

    public int partition(List<int[]> nums, int low, int high) {
        int[] pivot = nums.get(low);
        while (low < high) {
            while (low < high && nums.get(high)[1] <= pivot[1]) {
                high--;
            }
            nums.set(low, nums.get(high));
            while (low < high && nums.get(low)[1] >= pivot[1]) {
                low++;
            }
            nums.set(high, nums.get(low));
        }
        nums.set(low, pivot);
        return low;
    }

    public void quickSort(List<int[]> nums, int low, int high, int k, int indexRes, int[] res) {
        if (low <= high && k > 0) {
            int pivot = partition(nums, low, high);
            if (k >= pivot - low + 1) {
                for (int i = low; i <= pivot; i++) {
                    res[indexRes++] = nums.get(i)[0];
                }
                quickSort(nums, pivot + 1, high, k - (pivot - low + 1), indexRes, res);
            } else if (k < pivot - low + 1) {
                quickSort(nums, low, pivot - 1, k, indexRes, res);
            }
        }
    }
//    public int partition(int[][] nums, int low, int high) {
//        int pivot1 = nums[low][1];
//        int pivot0 = nums[low][0];
//        while (low < high) {
//            while (low < high && nums[high][1] <= pivot1) {
//                high--;
//            }
//            nums[low][1] = nums[high][1];
//            nums[low][0] = nums[high][1];
//            while (low < high && nums[low][1] >= pivot1) {
//                low++;
//            }
//            nums[high][1] = nums[low][1];
//            nums[high][0] = nums[low][0];
//        }
//        nums[low][1] = pivot1;
//        nums[low][0] = pivot0;
//
//        return low;
//    }

//    public void quickSort(int[][] nums, int low, int high, int k, int indexRes, int[] res) {
//        if (low < high && k > 0) {
//            int pivot = partition(nums, low, high);
//            if (k >= pivot - low + 1) {
//                for (int i = low; i <= pivot; i++) {
//                    res[indexRes++] = nums[i][0];
//                }
//                quickSort(nums, pivot + 1, high, k - (pivot - low + 1), indexRes, res);
//            } else if (k < pivot - low + 1) {
//                quickSort(nums, low, pivot - 1, k, indexRes, res);
//            }
//        }
//    }

    public static void main(String[] args) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        heap.add(6);
//        heap.add(4);
//        heap.add(3);
//        heap.remove();
//        heap.add(5);
        int[] nums = {1, 1, 1, 2, 2, 3};
        new Solution().topKFrequent2(nums, 2);
    }
}
