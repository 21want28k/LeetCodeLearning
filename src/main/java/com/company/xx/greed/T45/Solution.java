package com.company.xx.greed.T45;

public class Solution {
    public static int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int i = 0; // i代表每次落的位置
        int next = 0; // next代表下一个位置
        int count = 0;
        while (i < n) {
            // 如果能凭借着自己就可以到达最后一个index，就不需要继续往下跳了
            if (i + nums[i] >= n - 1) {
                count++;
                return count;
            }

            // 开始寻找下一个跳跃的位置
            int j = i + 1;
            //对i位置能走到的位置，看下一个位置最多能在哪
            int maxInstance = Integer.MIN_VALUE;
            while (j < n && j - i <= nums[i]) {
                if (j + nums[j] >= maxInstance) {
                    maxInstance = j + nums[j];
                    next = j;
                }
                j++;
            }
            i = next;// 跳跃一次
            count++;
//            if (i >= n - 1) {
//                return count;
//            }
        }
        return -1;
    }

    public static int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{2, 3, 1, 1, 4};
//        int[] nums = new int[]{1, 1, 1, 1, 1};
//        int[] nums = new int[]{2, 3, 0, 1, 4};
//        int[] nums = new int[]{2, 3, 1};
//        int[] nums = new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        int[] nums = new int[]{2, 0, 0, 0};
        System.out.println(jump(nums));
    }
}
