package com.company.xx.栈和队列.T225.用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;
    int peek = 0;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        while (size != 1) {
            queue.offer(queue.poll());
            size--;
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
