package com.company.xx.剑指offer.剑指Offer_30_包含min函数的栈;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stackA;
    Stack<Integer> stackB;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.push(x);
        if (stackB.isEmpty() || x <= stackB.peek()) {
            stackB.push(x);
        }
    }

    public void pop() {
        Integer x = stackA.pop();
        // use equals instead of == !!!
        if (x != null && x.equals(stackB.peek())) {
            stackB.pop();
        }
    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        return stackB.peek();
    }
}
