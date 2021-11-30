package com.company.xx.greed.T55;

import java.util.Arrays;

public class Solution {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] results = new boolean[n];
        if (n == 1) {
            return true;
        }

        if (nums[0] == 0) {
            return false;
        }

        results[0] = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && i + 1 < n && results[i + 1] == false) {
                return false;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j <= n - 1) {
                    results[i + j] = true;
                }
            }
        }
        System.out.println(Arrays.toString(results));
        return results[n - 1];
    }

    /**
     * 有缺陷的代码
     *
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        boolean[] results = new boolean[n];
        int i = 0;
        while (i < n - 1) {
            // 无路可走
            if (nums[i] == 0) {
                return false;
            }

            //下一步到开始
            int j = i + 1;
            while (j <= i + nums[i] && j < n) {
                results[j] = true;
                j++;
            }

            // 能走到到最后一步
            i = j - 1;
            if (i < n - 1 && results[i] == false) {
                return false;
            }
        }
        return results[n - 1];
    }

    public static boolean canJump3(int[] nums) {
        int n = nums.length;
        int rightmost = 0; // 能到达的最远index
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                // 可能出现[...5,0,0]这种情况，这次的不如上次的远
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 0, 0};
//        int[] nums = new int[]{2, 3, 1, 1, 4};
//        int[] nums = new int[]{3, 2, 1, 0, 4};
        int[] nums = new int[]{2, 5, 0, 0};
//        int[] nums = new int[]{1, 0, 1, 0};
        System.out.println(canJump2(nums));
    }
}
