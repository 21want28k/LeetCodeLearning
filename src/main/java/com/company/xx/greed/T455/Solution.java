package com.company.xx.greed.T455;

import java.util.Arrays;

public class Solution {
    /**
     * @param g 小孩
     * @param s 饼干
     * @return 最多满足的小孩数量
     */
    public static int findContentChildren(int[] g, int[] s) {
        int n = s.length;
        int m = g.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int num = 0;
        while (i < n && j < m) {
            if (s[i] >= g[j]) {
                j++;
                num++;
            }
            i++;
        }
        return num;
    }

    public static int findContentChildren2(int[] g, int[] s) {
        int n = s.length;
        int m = g.length;

        Arrays.sort(g);

        int i = 0;
        int num = 0;
        while (i < n) {
            for (int j = m - 1; j >= 0; j--) {
                if (s[i] >= g[j]) {
                    num++;
                    break;
                }
            }
            i++;
        }
        return num;
    }

    public static void main(String[] args) {
//        int[] g = new int[]{1, 2, 3};
//        int[] s = new int[]{1, 1};
        int[] g = new int[]{10, 9, 8, 7};
        int[] s = new int[]{5, 6, 7, 8};

        System.out.println(findContentChildren2(g, s));
    }
}
