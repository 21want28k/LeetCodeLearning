package com.company.xx.TOP100.T11盛最多水的容器;

public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int max = 0;
        while (left < right) {
            max = height[left] < height[right] ? Math.max((right - left) * height[left++], max) : Math.max((right - left) * height[right--], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {2, 3, 10, 5, 7, 8, 9};
        new Solution().maxArea(height);
    }
}
