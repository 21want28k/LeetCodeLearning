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


    public static void bucketSort(int[] a, int max) {
        int[] buckets;

        if (a == null || max < 1)
            return;

        // 创建一个容量为max的数组buckets，并且将buckets中的所有数据都初始化为0。
        buckets = new int[max];

        // 1. 计数
        for (int i = 0; i < a.length; i++)
            buckets[a[i]]++;

        // 2. 排序
        for (int i = 0, j = 0; i < max; i++) {
            while ((buckets[i]--) > 0) {
                a[j++] = i;
            }
        }

        buckets = null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(680142203, 1111953568));
        int i;
        int a[] = {8, 2, 3, 4, 3, 6, 6, 3, 9};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        bucketSort(a, 10); // 桶排序

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
