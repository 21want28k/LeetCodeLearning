package com.company.xx.剑指offer.剑指Offer_59_II_队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> maxDeque;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxDeque = new LinkedList<>();
    }

    public int max_value() {
        if (maxDeque.isEmpty()) {
            return -1;
        }
        return maxDeque.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!maxDeque.isEmpty() && value > maxDeque.getLast()) {
            maxDeque.removeLast();
        }
        maxDeque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int value = queue.remove();
        if (maxDeque.getFirst() == value) {
            maxDeque.removeFirst();
        }
        return value;
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.max_value();
        maxQueue.pop_front();
        maxQueue.max_value();
    }
}
