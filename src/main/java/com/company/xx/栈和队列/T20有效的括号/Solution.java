package com.company.xx.栈和队列.T20有效的括号;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('[',']');
        map.put('{','}');
        map.put('(',')');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                if (map.get(stack.peek()) == s.charAt(i)){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
