package com.company.xx.剑指offer.剑指Offer_59I_滑动窗口的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    Deque<Integer> deque = new LinkedList<>();
    Queue<Integer> queue = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0){
            return new int[]{};
        }
        int[] res = new int[n - k + 1];
        int i = 0;
        int j;
        for (j = 0; j < k; j++) {
            add(nums[j]);
        }
        res[i] = getMax();
        while (j<n) {
            outFirst();
            add(nums[j++]);
            res[++i] = getMax();
        }
        return res;
    }


    public void outFirst() {
        Integer value = queue.remove();
        if (value.equals(deque.getFirst())) {
            deque.removeFirst();
        }
    }

    public void add(int num) {
        queue.add(num);
        while (!deque.isEmpty() && deque.getLast() < num) {
            deque.removeLast();
        }
        deque.addLast(num);
    }

    public int getMax() {
        return deque.getFirst();
    }

    public static void main(String[] args) {
        int[] nums = {-7,-8,7,5,7,1,6,0};
        int k = 4;
        new Solution().maxSlidingWindow(nums, k);
        int a = Integer.MIN_VALUE;
    }
}
