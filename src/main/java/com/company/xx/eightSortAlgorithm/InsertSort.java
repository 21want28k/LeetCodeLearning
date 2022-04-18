package com.company.xx.eightSortAlgorithm;

public class InsertSort {

    public static void sort(int[] nums) {
        int n = nums.length;
        if (nums.length == 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int temp = nums[i];
            // i是待插入的序列头部，[0,i-1]是已排序的
            int j = i - 1;
//            while (j >= 0) {
//                if (temp < nums[j]) {
//                    nums[j + 1] = nums[j];
//                    j--;
//                } else {
//                    break;
//                }
//            }
            // 上面的代码换一种写法，等效的
            while (j >= 0 && temp < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            // 因为找到了位置仍会j--,所以最终目标位置是j+1
            nums[j + 1] = temp;
        }
    }


    public static int findPos(int[] nums, int low, int high, int number) {
        while (low < high) {
            int mid = low + (high - low) >> 1;
            if (nums[mid] > number) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {20, 12, 15, 1, 5, 49, 58, 24, 578, 211, 20, 214, 78, 35, 125, 789, 11};
        sort(nums);

    }
}
