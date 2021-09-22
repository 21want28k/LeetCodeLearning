package com.company.xx.T55_跳跃问题;

/**
 * 属于存在性问题，动态规划四步骤，
 * 1。最后一步；
 * 2。转换为子问题；
 * 3。写出转移方程；
 * 4。定初始值，注意边界情况，看是从小到大算，还是从大到小，到看状态转移方程
 */
public class Demo {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        boolean result[] = new boolean[n];
        // 初始条件
        result[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 能不能到j上，并且能不能从j的位置跳到i的位置
                if (result[j] == true && (i - j) <= nums[j]) {
                    result[i] = true;
                    break;
                }else {
                    result[i] = false;
                }
            }
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,0};
        System.out.println(canJump(nums));
    }
}