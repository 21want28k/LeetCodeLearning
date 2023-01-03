package com.company.xx.other.T454四数相加II;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int count = 0;

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int[][] nums = new int[4][n];
        nums[0] = nums1;
        nums[1] = nums2;
        nums[2] = nums3;
        nums[3] = nums4;
        dfs(nums, 0, 0);
        return count;
    }

    public void dfs(int[][] nums, int index, int target) {
        if (index == nums.length) {
            if (target == 0) {
                count++;
            }
            return;
        }
        int n = nums[index].length;
        for (int i = 0; i < n; i++) {
            dfs(nums, index + 1, target - nums[index][i]);
        }
    }

    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map12 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int key = nums1[i] + nums2[j];
                map12.put(key, map12.getOrDefault(key, 0) + 1);
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int key = 0 - nums3[i] - nums4[j];
                count += map12.getOrDefault(key, 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {7, -30, -31, -22, 4, 1, -2, -26, 0, -14, 4, -26, -28, 5, -4, -11, 6, -30, 3, -6, -21, -4, -13, -23, -13, 2, -4, -31, -2, -17, 5, -26, 1, -12, 9, -30, -29, -20, 1, -20, -4, -28, -22, -25, 8, -24, 10, -6, -8, -5, -2, -21, -18, -19, -7, -26, -10, -18, -20, 7, -20, -19, 0, -28, -25, -32, -9, 4, -9, 6, -1, -4, -26, -14, 4, -20, 10, -19, 3, -1, 7, -15, -7, 7, -5, -25, -32, -11, -14, -7, -10, 7, -12, -2, -27, -7, -32, -3, -20, -8};
        int[] nums2 = {-3, 4, -30, -31, -17, 6, -17, -32, -23, 5, -5, -32, -7, 9, 10, -20, 3, -2, -10, -27, -6, -31, -22, -31, -1, -5, -29, 8, 2, -27, -18, -30, -14, 2, -24, -22, -10, -11, -32, 9, -5, -22, -15, -32, 1, -28, 5, -17, -16, -32, -3, -1, -19, 6, -28, -9, 3, -10, -7, -4, 9, -32, -6, -31, -26, 9, -24, 5, -12, 10, -28, -21, 5, 3, -14, -5, 4, -9, -3, -16, -15, -4, 3, -4, -4, -30, -16, 10, 8, 2, -5, -1, -21, 5, -3, -17, -21, -29, 4, -4};
        int[] nums3 = {-21, 6, -7, -20, 8, -27, -3, 7, -28, 7, -23, -6, -10, -5, 10, 10, -10, -32, -5, -9, 4, 2, 6, -10, -1, -2, -15, -24, -22, 0, -18, 6, -24, -2, -15, -5, 4, -21, 7, 10, -25, -11, 2, 8, 10, -30, -16, 3, -16, -15, 5, -6, -9, -28, -31, -14, -29, -32, -19, -18, -7, -16, 0, -32, 2, -24, -20, -2, -20, -24, -32, -18, -19, -1, 0, -13, -14, -32, -8, 10, -17, -24, -2, -10, -8, 8, -29, 7, -18, -18, 0, -27, 3, -16, -6, 0, -15, 8, -32, -8};
        int[] nums4 = {0, 10, -25, -3, -18, -8, 9, 9, -4, -15, -11, -1, -4, -4, 5, -23, -6, -12, -12, -8, 9, -31, 8, -1, -23, -12, -12, -2, 5, -19, -14, 5, -9, 8, 10, -13, -23, -18, -10, 1, 7, -21, 9, -16, 5, -21, 10, 6, -10, -18, -5, 6, -26, -13, -6, -13, -5, -6, -20, -9, 1, -8, -15, 3, -13, 9, -9, -7, -10, -32, -16, 10, -26, -12, -20, -5, 10, -22, -30, -26, -16, 4, -17, -18, -4, -11, -19, -19, -25, -11, -7, 2, -24, -4, -31, -5, -14, -12, -19, -5};
        new Solution().fourSumCount(nums1, nums2, nums3, nums4);
    }
}
