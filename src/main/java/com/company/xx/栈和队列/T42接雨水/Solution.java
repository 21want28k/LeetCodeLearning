package com.company.xx.栈和队列.T42接雨水;

import java.util.Map;
import java.util.Stack;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int iLeftMax = 0, jRightMax = 0;
        int ans = 0;
        while (left < right) {
            iLeftMax = Math.max(iLeftMax, height[left]);
            jRightMax = Math.max(jRightMax, height[right]); // 边遍历边维护这两个值。
            if (iLeftMax < jRightMax) { // 根据公式进行计算
                ans += iLeftMax - height[left++];
            } else {
                ans += jRightMax - height[right--];
            }
        }
        return ans;
    }

    public int trap2(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                ans += (Math.min(height[i], height[left]) - height[top]) * (i - left - 1);
            }
            stack.push(i);
        }
        return ans;
    }

    public int trap3(int[] height) {
        int ans = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }
}
