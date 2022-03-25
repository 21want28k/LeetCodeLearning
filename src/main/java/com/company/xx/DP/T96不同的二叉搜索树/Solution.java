package com.company.xx.DP.T96不同的二叉搜索树;

public class Solution {
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;

        // 外层循环代表G2~Gn
        for (int i = 2; i <=n ; i++) {
            // 内层循环代表求和，公式中的1~n求和就是这里的1~i求和
            for (int j = 1; j <=i ; j++) {
                G[i] += G[j-1] * G[i-j];
             }
        }
        return G[n];
    }


    public static void main(String[] args) {
        new Solution().numTrees(3);
    }
}
