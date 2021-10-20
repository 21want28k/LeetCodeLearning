package com.company.xx.T343_整数拆分_看的答案;

public class Demo {
    public static int integerBreak(int n) {
        // 1。确定状态; dp[i] 代表拆分i能获得的最大乘积
        // 2。两种方法确定dp[i]，
        //    如果先拆一个j出来，
        //    假设分成 j 和 i-j，j是从1开始遍历的，所以不用拆j了
        //    如果i-j继续拆 最大乘积就是j * dp[i-j]
        //    如果i-j不拆分 最大乘积就是j * (i-j)
        //    转移方程dp[i] = Math.max(j * dp[i-j], dp[j] * (i-j))
        // 3。确定初值: dp[1]
        // 4。确定计算顺序，很明显从左到右
        int[] dp = new int[n + 1];// 1~n
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            // j每+1，代表一种分割方法，由于要找出乘积最大值，需要对所有的拆分方法求一个最大。
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * dp[i - j], j * (i - j)));
            }
            // 最大的乘积赋值给dp[i]
            dp[i] = curMax;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
