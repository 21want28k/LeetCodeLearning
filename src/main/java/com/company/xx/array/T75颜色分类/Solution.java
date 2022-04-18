package com.company.xx.array.T75颜色分类;

import com.company.xx.utils.MyArrayUtil;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        int i = 0;
        while (i <= two) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                MyArrayUtil.swap(nums, i, zero);
                zero++;
                i++;
            } else {
                MyArrayUtil.swap(nums, i, two);
                two--;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 1};
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
