package com.company.xx.greed.T860_Lemonade_Change;

public class Solution {
    public static boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int[] changes = new int[3]; // 5, 10, 20

        for (int i = 0; i < n; i++) {
            switch (bills[i]) {
                case 5:
                    changes[0]++;
                    break;
                case 10: {
                    if (changes[0] > 0) {
                        changes[1]++;
                        changes[0]--;
                    } else {
                        return false;
                    }
                    break;
                }
                case 20: {
                    if (changes[1] > 0 && changes[0] > 0) {
                        changes[2]++;
                        changes[0]--;
                        changes[1]--;
                    } else if (changes[1] == 0 && changes[0] >= 3) {
                        changes[0] = changes[0] - 3;
                    } else {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    public static boolean lemonadeChange2(int[] bills) {
        int n = bills.length;
        int fiveNum = 0;
        int tenNum = 0;

        for (int i = 0; i < n; i++) {
            switch (bills[i]) {
                case 5:
                    fiveNum++;
                    break;
                case 10: {
                    if (fiveNum > 0) {
                        tenNum++;
                        fiveNum--;
                    } else {
                        return false;
                    }
                    break;
                }
                case 20: {
                    if (tenNum > 0 && fiveNum > 0) {
                        fiveNum--;
                        tenNum--;
                    } else if (tenNum == 0 && fiveNum >= 3) {
                        fiveNum = fiveNum - 3;
                    } else {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] bills = new int[]{5, 5, 5, 10, 20};
        int[] bills = new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        System.out.println(lemonadeChange(bills));
    }
}
