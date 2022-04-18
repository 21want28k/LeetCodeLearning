package com.company.xx.eightSortAlgorithm;

public class QuickSort {

    public int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] > pivot) { // 从右开始找到第一个比pivot值小的数
                high--;
            }
            nums[low] = nums[high]; // 因为nums[low]的值已经被保存在pivot中了，所以直接放进nums[low]上
            while (low < high && nums[low] < pivot) { // 从左开始找到第一个比pivot值大的数
                low++;
            }
            nums[high] = nums[low]; // 同理
        }
        nums[low] = pivot; // 最后low == high也就是pivot该放的位置
        return low;
    }

    public void quickSort(int[] nums, int low, int high) {
        // 为什么low<high就可以了？因为low < high代表至少两个元素，如果只是一个元素就不用继续划分了
        if (low < high) {
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1); // [low, pivot-1]是一个分区
            quickSort(nums, pivot + 1, high); // [pivot+1, high]是另一个分区
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,6,3,8,33,27,66,9,7,88};
        new QuickSort().quickSort(nums, 0, nums.length - 1);
    }
}
