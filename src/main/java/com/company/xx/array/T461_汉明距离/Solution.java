package com.company.xx.array.T461_汉明距离;

public class Solution {
    /**
     * 一定要注意大数问题，一直左移会超过int的最大值从而变成负数
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int m = 1;
        int count = 0;
        int num = x ^ y;
        while (m <= num && m > 0) {
            if ((num & m) != 0) {
                count++;
            }
            m <<= 1;
        }
        return count;
    }

    /**
     * 可以解决上面的问题
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance2(int x, int y) {
        int count = 0;
        int num = x ^ y;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }

    public int hammingDistance3(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(680142203, 1111953568));
    }
}
