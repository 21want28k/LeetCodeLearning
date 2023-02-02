package com.company.xx.TOP100.T75颜色分类;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = 0;
        int two = n - 1;
        for (int i = 0; i <= two; i++) {
            while (nums[i] == 2 && i < two) {
                swap(nums, i, two);
                two--;
            }
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        new Solution().sortColors(nums);
    }

    public InnerClass newInstanceByReflection() {
        // 获取虚拟机中 InnerClass 类的 Class 对象
        Class clazz = InnerClass.class;
        try {
            return (InnerClass) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
