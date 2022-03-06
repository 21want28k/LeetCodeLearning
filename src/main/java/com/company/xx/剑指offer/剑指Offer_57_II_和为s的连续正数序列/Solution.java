package com.company.xx.剑指offer.剑指Offer_57_II_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[][]{};
        }
        List<int[]> temp = new ArrayList<>();
        int left = 1;
        int right = 2;
        int sum = left + right;
        while (left <= target / 2) {
            if (sum < target) {
                right++;
                sum += right;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] store = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    store[i - left] = i;
                }
                temp.add(store);
                right++;
                sum += right;
            }
        }
        return temp.toArray(new int[temp.size()][]);
    }

    public static void main(String[] args) {
        int target = 9;
        System.out.println(Arrays.deepToString(new Solution().findContinuousSequence(target)));
    }
}