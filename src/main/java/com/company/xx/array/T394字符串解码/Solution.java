package com.company.xx.array.T394字符串解码;

import java.util.LinkedList;

public class Solution {
    public String decodeString(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                while (!stack.isEmpty() && Character.isAlphabetic(stack.peek())) {
                    stringBuilder.insert(0, stack.pop());
                }
                // 去掉[
                stack.pop();

                StringBuilder numberBuilder = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    numberBuilder.insert(0, stack.pop());
                }
                int number = Integer.parseInt(numberBuilder.toString());
                for (int n = 1; n <= number; n++) {
                    for (char c1 : stringBuilder.toString().toCharArray()) {
                        stack.push(c1);
                    }
                }
            }
        }
        StringBuilder ansBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            ansBuilder.insert(0, stack.pop());
        }
        return ansBuilder.toString();
    }


    public static void main(String[] args) {
        String s = "3[a2[c]]";
        new Solution().decodeString(s);
    }
}
