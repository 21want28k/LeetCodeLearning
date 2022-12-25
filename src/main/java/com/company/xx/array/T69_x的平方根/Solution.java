package com.company.xx.array.T69_x的平方根;

public class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int pos = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (mid * mid > x) {
                high = mid - 1;
            } else {
                pos = mid;
                low = mid + 1;

            }

        }
        return pos;
    }

    public static void main(String[] args) {
        new Solution().mySqrt(4);
    }
}
