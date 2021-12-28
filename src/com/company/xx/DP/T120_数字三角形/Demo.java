package com.company.xx.DP.T120_数字三角形;

import java.util.List;

/**
 * 题解：分析问题：最上一层到最下一层首先要经过第二层，一共有两种方法，向左或者向右，如果知道了第二层两个节点到最下层到最小值，就可以计算出
 * 第一层到最后一层到最小路径，于是问题转换为求第二层节点到最后一层节点的最小路径。依次类推。。。。改变思路，知道了最后一层的最短路径，
 * 就可以反推出倒数第二层到最后一层的最小路径，从上到下的思想改变为从下到上到思路。因为上层都依赖于下层的值。
 * 第一步：DP状态->定义为某一个节点[i][j]到最后一层的值。
 * 第二步: 转移方程->f[i][j]=min(f[i+1][j]左节点,f[i+1][j+1]右节点)+ A[i][j]本身的值
 * 第三步：初始条件->由状态看出，左边的式子依赖于右边的式子，先定义最后一层的值
 */
public class Demo {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 虽然是n层，但是定义n+1行，n+1列的好处在于，把最后一层看成全0的，这样就可以不用手动定义第n行的初始值，可以通过状态转移方程算出第
        // n行的初始值
        int f[][] = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return f[0][0];
    }

    /**
     * 空间优化，思路在于算某一行的时候并不会用到其他行的，只需要下一个行的数据，所以复用一维数组，每次只需要记录那一行的值就行。
     * i = n-1时,dp[0] = 4, dp[1] = 1, dp[2] = 8, dp[3] = 3
     * i = n-2时,dp[0] = 7, dp[1] = 6, dp[2] = 10, dp[3] = 3; dp[0]~dp[2]是倒数第二行的到最后一层到最短路径。复用了一维数组
     */
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {

    }
}
