package com.company.xx.DP.T509_DP_斐波拉契数列;

import java.util.Arrays;

/**
 * @author xx
 * @date 2021/10/4 20:12
 */
public class Demo {
    public int fib(int n) {
        // 1. 确定状态,dp[i] 代表第i个斐波拉契数列的值（0~n-1）
        // 2. 递推公式dp[i] = dp[i-1] + dp[i-2];
        // 3. 确定初值dp[0] = 1; dp[1] = 1;处理边界，从dp递推公式看，i=0，i=1时数组下标越界，所以0,1需要特殊处理
        // 4. 确定顺序，后面的值依赖于前面的值，所以是从左到右
        // 5. 打印dp数组
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    /**
     * 在原来的基础上优化，因为后一个数，只依赖于前两个数的状态，所以可以进行复用
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        // 1. 确定状态,dp[i] 代表第i个斐波拉契数列的值（0~n-1）
        // 2. 递推公式dp[i] = dp[i-1] + dp[i-2];
        // 3. 确定初值dp[0] = 1; dp[1] = 1;处理边界，从dp递推公式看，i=0，i=1时数组下标越界，所以0,1需要特殊处理
        // 4. 确定顺序，后面的值依赖于前面的值，所以是从左到右
        // 5. 打印dp数组
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            // 因为只需要前两个数的状态，将值往前移一个，sum记录第n个斐波那契值
            sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        System.out.println(d.fib2(7));
    }
}