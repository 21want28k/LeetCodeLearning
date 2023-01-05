package com.company.xx.栈和队列.T239滑动窗口最大值;

import netscape.security.UserTarget;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static class myQueue {
        Deque<Integer> queue = new LinkedList<>();

        public void push(int val) {
            while (!queue.isEmpty() && val > queue.peekLast()) {
                queue.pollLast();
            }
            queue.add(val);
        }

        public void poll(int val) {
            if (!queue.isEmpty() && val == queue.peek()) {
                queue.poll();
            }
        }

        public int peek() {
            return queue.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        myQueue queue = new myQueue();
        int n = nums.length;
        if (n <= k) {
            for (int i = 0; i < n; i++) {
                queue.push(nums[i]);
            }
            return new int[]{queue.peek()};
        }

        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        int[] res = new int[n - k + 1];
        int index = 0;
        res[index++] = queue.peek();
        for (int i = k; i < n; i++) {
            queue.poll(nums[i - k]);
            queue.push(nums[i]);
            res[index++] = queue.peek();
        }
        return res;
    }
}
