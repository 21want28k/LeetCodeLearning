package com.company.xx.TOP100.T20有效的括号;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case '(': {
                    stack.push(')');
                    break;
                }
                case '[': {
                    stack.push(']');
                    break;
                }
                case '{': {
                    stack.push('}');
                    break;
                }
                default: {
                    if (stack.peek() == s.charAt(i)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
