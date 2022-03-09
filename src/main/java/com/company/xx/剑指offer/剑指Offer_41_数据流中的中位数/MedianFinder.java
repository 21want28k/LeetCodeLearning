package com.company.xx.剑指offer.剑指Offer_41_数据流中的中位数;

import java.util.PriorityQueue;

public class MedianFinder {

    // min
    public PriorityQueue<Integer> A;
    // max
    public PriorityQueue<Integer> B;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    }

    public void addNum(int num) {
        if (A.size() == B.size()) {
            B.add(num);
            A.add(B.poll());
        } else {
            A.add(num);
            B.add(A.poll());
        }
    }

    public double findMedian() {
        if (A.size() != B.size()) {
            return A.peek();
        } else {
            return (A.peek() + B.peek()) / 2.0;
        }
    }
}
