package com.company.xx.T322_零钱问题;

public class Demo {
    public int coinChange(int[] coins, int amount) {

        // 开一个数组，f[0]到f[amount]所以是amount+1
        int f[] = new int[amount + 1];

        int n1 = f.length;
        // 硬币的数目
        int n2 = coins.length;

        // initialization 初始条件
        f[0] = 0;
        for (int i = 1; i < n1; i++) {
            // 先给数组赋值初值，比这个好就替换掉
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n2; j++) {
                // 数组不能越界，并且java最大值+1是会报错的
                if (i - coins[j] >= 0 && f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
                }
            }
        }
        if (f[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return f[amount];
    }

    public static void main(String[] args) {
        int f[] = new int[]{1,2,5};
        int amount = 11;
        Demo demo = new Demo();
        System.out.println(demo.coinChange(f,amount));
    }
}