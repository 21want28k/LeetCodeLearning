package com.company.xx.DP.T15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        /*
            排序主要是为了答案要求不重复，如果说已经是排序好的，那么结果一定是不重复的
         */
        Arrays.sort(nums);
        /*
            如果定下了第一个数，那么就可以把问题缩小到：有序数组，两个数的和是一个指定的数，用双指针就可以找到剩余的解
         */
        for (int first = 0; first < nums.length; first++) {
            // 主要是避免重复，>0是防止数组越界
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            if (nums[first] > 0) {
                return result;
            }
            int l = first + 1;
            int r = nums.length - 1;
            while (l < r) {
                int tmp = nums[first] + nums[l] + nums[r];
                if (tmp > 0) {
                    r--;
                }
                if (tmp < 0) {
                    l++;
                }
                if (tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    // 这么写死循环
//                    while (l < r) {
//                        // 跳过重复的值
//                        if (nums[l] == nums[l + 1]) {
//                            l++;
//                        }
//                        if (nums[r] == nums[r - 1]) {
//                            r--;
//                        }
//                    }
                    // 重复跳过
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(ints));
    }
}