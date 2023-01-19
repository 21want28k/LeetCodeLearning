package com.company.xx.greed.T135_Candy;

import java.util.Arrays;

public class Solution2 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candis = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                candis[i] = candis[i - 1] + 1;
            } else {
                candis[i] = 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                candis[i] = Math.max(candis[i + 1] + 1, candis[i]);
            }
        }
        return Arrays.stream(candis).sum();
    }

    public int candy2(int[] ratings) {
        int n = ratings.length;
        int res = 1;
        int dec = 0, inc = 1, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dec = 0;
                pre++;
                res += pre;
                inc = pre;
            } else if (ratings[i] == ratings[i - 1]) {
                dec = 0;
                pre = 1;
                res += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                res += dec;
                pre = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] r = {1, 0, 2};
        new Solution2().candy(r);
    }
}
