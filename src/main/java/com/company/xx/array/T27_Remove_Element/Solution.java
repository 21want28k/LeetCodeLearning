package com.company.xx.array.T27_Remove_Element;

public class Solution {
    /**
     * 前后指针解法
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int first = 0;
        int last = n - 1;
        int newLength = n;
        while (first <= last) {
            // 从后向前,
            while (first <= last && nums[last] == val) {
                newLength--;
                last--;
            }
            while (first <= last && nums[first] != val) {
                first++;
            }
            if (first < last) {
                int temp = nums[first];
                nums[first] = nums[last];
                nums[last] = temp;
            }
        }

//        return first;
        return newLength;
    }


    /**
     * 快慢指针解法
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int n = nums.length;
        int slow = 0;
        for (int fast = 0; fast < n; fast++) {
            if (nums[fast] != val) {
                // 没存入一个数之后slow++，所以slow代表数组中下一个将要存放值的位置
                // 也可以用作是代表数组的长度。
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public int removeElement3(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(s.removeElement3(nums, 3));
    }
}