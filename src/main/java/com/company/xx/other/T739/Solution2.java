package com.company.xx.other.T739;

import java.util.Stack;

public class Solution2 {
    int[] res;
    int[] temperatures;

    class Mystack {

        Stack<Integer> stack = new Stack<>();

        void push(int index) {
            while (!stack.isEmpty() && temperatures[index] > temperatures[stack.peek()]) {
                int i = stack.pop();
                res[i] = index - i;
            }
            stack.push(index);
        }

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        res = new int[n];
        this.temperatures = temperatures;
        Mystack mystack = new Mystack();
        for (int i = 0; i < n; i++) {
            mystack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        new Solution2().dailyTemperatures(t);
    }
}
