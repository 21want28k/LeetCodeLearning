package com.company.xx.array.T215_Kth_Largest_Element_in_an_Array;

public class Solution {
    /* 方法一：快排的思想*/
    public int findKthLargest(int[] nums, int k) {
//        if (k == 1 && nums.length == 1) {
//            return nums[0];
//        }
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }


    public int quickSelect(int[] nums, int low, int high, int k) {
        if (low <= high) {
            int pivot = partition(nums, low, high);
            if (pivot < k) {
                return quickSelect(nums, pivot + 1, high, k);
            } else if (pivot > k) {
                return quickSelect(nums, low, pivot - 1, k);
            } else {
                return nums[pivot];
            }
        }
        return -1;
    }

    public int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] <= pivot) {
                high--;
            }
            nums[low] = nums[high];

            while (low < high && nums[low] >= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }


    /* 方法二：堆排序*/
    public void adjustFromUpToDown(int[] nums, int index, int scale) {
        int temp = nums[index];
        for (int leftChild = 2 * index + 1; leftChild <= scale; leftChild = 2 * index + 1) {
            int rightChild = leftChild + 1;
            int swappedChild = leftChild;
            if (rightChild <= scale && nums[rightChild] > nums[leftChild]) {
                swappedChild = rightChild;
            }
            if (nums[swappedChild] > temp) {
                nums[index] = nums[swappedChild];
                index = swappedChild;
            } else {
                break;
            }
        }
        nums[index] = temp;
    }

    public void build(int[] nums) {
        for (int i = (nums.length / 2 - 1); i >= 0; i--) {
            adjustFromUpToDown(nums, i, nums.length - 1);
        }
    }

    public void delete(int[] nums) {

    }

    public int findKthLargest2(int[] nums, int k) {
//        if (k == 1 && nums.length == 1) {
//            return nums[0];
//        }
        build(nums);
        int time = 1;
        int scale = nums.length;
        while (time != k) {
            scale--;
            nums[0] = nums[scale];
            adjustFromUpToDown(nums, 0, scale);
            time++;
        }

        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(new Solution().findKthLargest2(nums, 2));
    }
}
