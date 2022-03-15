package com.company.xx.other.T2044统计按位或能得到最大值的子集数目;

import java.util.HashMap;
import java.util.Map;

class Solution {
    static Map<Integer, Integer> map = new HashMap<>();

    static {
        for (int i = 0; i < 20; i++) map.put((1 << i), i);
    }

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length, mask = 1 << n;
        int[] f = new int[mask];
        int max = 0, ans = 0;
        for (int s = 1; s < mask; s++) {
            int lowbit = (s & -s);
            int prev = s - lowbit, idx = map.get(lowbit);
            f[s] = f[prev] | nums[idx];
            if (f[s] > max) {
                max = f[s];
                ans = 1;
            } else if (f[s] == max) {
                ans++;
            }
        }
        return ans;
    }

    public int countMaxOrSubsets2(int[] nums) {
        int n = nums.length;
        int mask = 1 << n;
        int res = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mask; i++) {
            int temp = 0;
            // 扫描i上的每个位上是否是1
            // scan every bit of num i to judge whether is 1 or 0.
            for (int j = 0; j < n; j++) {
                // 通过向右移动j位，将i的当前位与1对齐来判断，当前位是0还是1
                // right remove j bits to align the cur bit of num i and 1, then judge the cur bit of num i is 0 or 1.
                if (((i >> j) & 1) == 1) {
                    temp |= nums[j];
                }
            }
            if (temp == max) {
                res++;
            } else if (temp > max) {
                res = 1;
                max = temp;
            }
        }
        return res;
    }

    public int countMaxOrSubsets3(int[] nums) {
        int n = nums.length;
        this.max = Integer.MIN_VALUE;
        this.res = 0;
        this.nums = nums;
        dfs(0, 0);
        return this.res;
    }

    int max;
    int res;
    int[] nums;

    public void dfs(int index, int val) {
        if (index == nums.length) {
            if (val > this.max) {
                res = 1;
                max = val;
            } else if (val == this.max) {
                res++;
            }
            return;
        }
        dfs(index + 1, val | nums[index]);
        dfs(index + 1, val);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5};
        new Solution().countMaxOrSubsets(nums);
    }
}
