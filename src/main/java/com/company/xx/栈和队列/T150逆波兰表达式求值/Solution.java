package com.company.xx.栈和队列.T150逆波兰表达式求值;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    Integer number1 = stack.pop();
                    Integer number2 = stack.pop();
                    stack.push(number1 + number2);
                    break;
                }
                case "-": {
                    Integer number1 = stack.pop();
                    Integer number2 = stack.pop();
                    stack.push(number2 - number1);
                    break;
                }
                case "*": {
                    Integer number1 = stack.pop();
                    Integer number2 = stack.pop();
                    stack.push(number1 * number2);
                    break;
                }
                case "/": {
                    Integer number1 = stack.pop();
                    Integer number2 = stack.pop();
                    stack.push(number2 / number1);
                    break;
                }
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }
}
