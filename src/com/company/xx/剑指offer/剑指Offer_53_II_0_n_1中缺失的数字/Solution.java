package com.company.xx.剑指offer.剑指Offer_53_II_0_n_1中缺失的数字;

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int head = 0;
        int tail = n - 1;
        while (nums[head] + nums[tail] == n && head < tail) {
            head++;
            tail--;
        }
        if (head > tail) {
            return nums[head] - 1;
        }
        if (nums[head] + nums[tail] > n) {
            return nums[head] - 1;
        } else {
            return nums[tail] + 1;
        }
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            }
        }
        // 缺失一共是三种情况，缺头，缺尾，缺中间
        return nums[mid] > mid ? nums[mid] - 1 : nums[mid] + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution s = new Solution();
        System.out.println(s.missingNumber2(nums));
    }
}
