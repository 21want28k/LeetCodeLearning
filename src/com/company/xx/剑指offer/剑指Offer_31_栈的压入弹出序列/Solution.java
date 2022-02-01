package com.company.xx.剑指offer.剑指Offer_31_栈的压入弹出序列;

import java.util.Stack;

public class Solution {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int indexPushed = 0;
        int indexPopped = 0;
        Stack<Integer> stack = new Stack<>();
        while (indexPopped < n) {
            if (!stack.empty() && stack.peek() == popped[indexPopped]) {
                stack.pop();
                indexPopped++;
            } else {
                if (indexPushed < n) {
                    stack.push(pushed[indexPushed++]);
                } else {
                    break;
                }
            }
        }
        return stack.empty();
    }

    /**
     * 比上面更好一点的写法
     * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/solution/mian-shi-ti-31-zhan-de-ya-ru-dan-chu-xu-lie-mo-n-2/
     *
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        int indexPopped = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && popped[indexPopped] == stack.peek()) {
                stack.pop();
                indexPopped++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] poped = new int[]{4, 3, 5, 1, 2};
        validateStackSequences(pushed, poped);
    }
}
