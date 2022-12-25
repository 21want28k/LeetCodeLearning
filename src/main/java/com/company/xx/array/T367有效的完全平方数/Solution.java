package com.company.xx.array.T367有效的完全平方数;

public class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
