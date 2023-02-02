package com.company.xx.TOP100.T42接雨水;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int iLeftMax = 0;
        int jRightMax = 0;
        int res = 0;
        while (i < j) {
            iLeftMax = Math.max(iLeftMax, height[i]);
            jRightMax = Math.max(jRightMax, height[j]);
            if (iLeftMax > jRightMax) {
                res += jRightMax - height[j];
            } else {
                res += iLeftMax - height[i];
            }
        }
        return res;
    }
}
