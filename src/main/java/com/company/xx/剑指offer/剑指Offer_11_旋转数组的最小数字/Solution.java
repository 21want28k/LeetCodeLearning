package com.company.xx.剑指offer.剑指Offer_11_旋转数组的最小数字;

public class Solution {
    public static int minArray(int[] numbers) {
        int n = numbers.length;
        int index = 1;
        while (index < n && numbers[index] >= numbers[index - 1]) {
            index++;
        }
        if (index == n) {
            return numbers[0];
        }
        return numbers[index];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 2, 2, 0, 1};
        System.out.println(minArray(numbers));
    }
}
