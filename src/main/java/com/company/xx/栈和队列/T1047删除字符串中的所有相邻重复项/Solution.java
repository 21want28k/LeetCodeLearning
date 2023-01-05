    package com.company.xx.栈和队列.T1047删除字符串中的所有相邻重复项;

import java.util.Stack;

public class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && s.charAt(i) == stack.peek()){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()){
            builder.insert(0,stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("abbaca"));
    }
}
