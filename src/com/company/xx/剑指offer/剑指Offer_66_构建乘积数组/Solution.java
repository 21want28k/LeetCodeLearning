package com.company.xx.剑指offer.剑指Offer_66_构建乘积数组;

public class Solution {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] result = new int[n];
        if (n == 0) {
            return result;
        }
        int[] iLeft = new int[n];
        int[] iRight = new int[n];
        iLeft[0] = 1;
        iRight[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            iLeft[i] = iLeft[i - 1] * a[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            iRight[i] = iRight[i + 1] * a[i + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = iLeft[i] * iRight[i];
        }
        return result;
    }

    public int[] constructArr2(int[] a) {
        int n = a.length;
        int[] result = new int[n];
        if (n == 0) {
            return result;
        }
        // 将原来的left数组直接用result代替
        result[0] = 1;
        int iRight = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * a[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            // 先计算出对应的i右边的乘积
            iRight = iRight * a[i + 1];
            // 将i左边的乘积和i右边的乘积相乘得到结果。记住，result[]=iLeft[]就是i左侧的乘积
            result[i] = result[i - 1] * iRight;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Solution s = new Solution();
        s.constructArr(nums);
    }
}
