package com.company.xx.剑指offer.剑指Offer_17_打印从1到最大的n位数;

import java.util.Arrays;

public class Solution {
    /**
     * 没有考虑大数字，比如越界时候的数字
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num += 9 * Math.pow(10, i - 1);
        }
        System.out.println(num);
        int[] result = new int[num]; // 1~num 共num个数字
        for (int i = 0; i < num; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    /**
     * 大数解法
     *
     * @param n
     * @return
     */
    int n, start, nineCount;
    StringBuilder builder = new StringBuilder();
    char[] num;
    char[] loop = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public String printNumbers2(int n) {
        this.n = n;
        num = new char[n];
        start = n - 1;
        dfs(0);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) builder.append(s + ",");
            if (n - start == nineCount) start--;
            return;
        }
        for (char c : loop) {
            if (c == '9') {
                nineCount++;
            }
            num[x] = c;
            dfs(x + 1);
        }
        nineCount--;
    }

    /**
     * 大数解法2
     *
     * @param n
     * @return
     */

    public int[] printNumbers3(int n) {
        this.n = n;
        num = new char[n];
        result = new int[(int) Math.pow(10, n) - 1];
        dfs2(0);
        return result;
    }

    int count;
    int[] result;

    public void dfs2(int x) {
        if (x == n) {
            String numberString = new String(num);
            int number = Integer.parseInt(numberString);
            if (number != 0) {
                result[count++] = number;
            }
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            num[x] = i;
            dfs2(x + 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.printNumbers2(2));
    }
}
