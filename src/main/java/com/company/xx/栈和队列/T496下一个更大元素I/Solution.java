package com.company.xx.栈和队列.T496下一个更大元素I;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                Integer value = stack.pop();
                map.put(value, nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            Integer value = map.get(nums1[i]);
            if (value == null) {
                res[i] = -1;
            } else {
                res[i] = value;
            }
        }
        return res;
    }
}
