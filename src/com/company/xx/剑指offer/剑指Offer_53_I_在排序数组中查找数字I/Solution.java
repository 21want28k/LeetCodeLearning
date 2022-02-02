package com.company.xx.剑指offer.剑指Offer_53_I_在排序数组中查找数字I;

public class Solution {
    public int search(int[] nums, int target) {
        return rBinarySearch(nums, target) - lBinarySearch(nums, target) + 1;
    }

    public int search2(int[] nums, int target) {
        return lBinarySearch(nums, target + 1) - lBinarySearch(nums, target);
    }

    public int lBinarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (target <= nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int rBinarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (target >= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        Solution s = new Solution();
        System.out.println(s.lBinarySearch(nums, 8));
    }
}
