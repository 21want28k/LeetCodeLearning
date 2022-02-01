package com.company.xx.剑指offer.剑指Offer_42_连续子数组的最大和;

public class Solution {
    public static int maxSubArray1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int n = nums.length;
        int pre = nums[0];
        int cur;
        int max = pre;
        for (int i = 1; i < n; i++) {
            if (pre > 0) {
                cur = pre + nums[i];
            } else {
                cur = nums[i];
            }
            max = Math.max(max, cur);
            pre = cur;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray1(nums));
    }

    class Status {
        public int iSum, lSum, rSum, mSum;

        public Status(int iSum, int lSum, int rSum, int mSum) {
            this.iSum = iSum;
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
        }
    }

    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        int m = l + ((r - l) >> 1);
        Status lStatus = getInfo(nums, l, m);
        Status rStatus = getInfo(nums, m + 1, r);
        return calculate(lStatus, rStatus);
    }

    public Status calculate(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(iSum, lSum, rSum, mSum);
    }
}
