package com.company.xx.greed.T860_Lemonade_Change;

public class Solution2 {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int[] coins = new int[3]; // 0:5；1:10；2:20
        for (int bill : bills) {
            if (bill == 20) {
                coins[2]++;
                if (coins[1] >= 1 && coins[0] >=1) {
                    coins[1]--;
                    coins[0]--;
                } else if (coins[0] >= 3) {
                    coins[0] -= 3;
                } else {
                    return false;
                }
            } else if (bill == 10) {
                coins[1]++;
                if (coins[0] >= 1) {
                    coins[0]--;
                } else {
                    return false;
                }
            } else if (bill == 5) {
                coins[0]++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        new Solution2().lemonadeChange(bills);
    }
}
