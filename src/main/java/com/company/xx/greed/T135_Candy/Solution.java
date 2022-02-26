package com.company.xx.greed.T135_Candy;

import java.util.Arrays;

public class Solution {

    public static int candy(int[] ratings) {
        int n = ratings.length;

        int[] candyDeliver = new int[n];
        for (int i = 0; i < n; i++) {
            candyDeliver[i] = 1;
        }


        for (int i = 1; i < n; i++) {
            // right > left
            if (ratings[i] > ratings[i - 1]) {
                // assert the right child's candy > the left
                candyDeliver[i] = candyDeliver[i - 1] + 1;
            } else {
                // keep one
            }
        }

        for (int i = n - 1; i >= 1; i--) {
            // left > right
            if (ratings[i] < ratings[i - 1]) {
                candyDeliver[i - 1] = Math.max(candyDeliver[i] + 1, candyDeliver[i - 1]);
            } else {
                // keep original to use former result
            }
        }

        System.out.println(Arrays.toString(candyDeliver));

        int sumCandy = 0;
        for (int candy : candyDeliver) {
            sumCandy += candy;
        }
        return sumCandy;
    }

    public static int candy2(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                // 出现递增的时候，就要重置降序序列的长度为0
                dec = 0;
                // 更新pre的值
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                // pre就是i这个位置的同学分配的糖果
                ret += pre;
                // pre的值等于递增序列的长度
                inc = pre;
            } else {
                dec++;
                // 为什么有这个呢？长度相等的时候，递增序列的最后一个就会变成递减序列的成员。
                // 比如rating = [1,3,5,3,2,1] 增加的糖果依次为1,2,3,1,2,4；特别是4这个位置，4是
                // dec== inc ==3的时候，把前面的3当做是降序的成员，我自己由3变成4.虽然分发的顺序不符合
                // 小孩的位置，但是不影响总的计数。实际分发应该是[1,2,4,3,2,1]这个顺序。
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                // pre只在递增的时候用到
                pre = 1;
            }
        }
        return ret;
    }

    public static int candy3(int[] ratings) {
        int n = ratings.length;

        int result = 1;
        int pre = 1, inc = 1, desc = 0;

        for (int i = 1; i <= n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                // 
                desc = 0;
                inc++;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                result += pre;
            } else {
                desc++;
                if (desc == inc) {
                    desc++;
                }
                result += desc;
                pre = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] ratings = new int[]{1, 3, 4, 5, 2};
        int[] ratings = new int[]{1, 2, 2, 5, 4, 3, 2};
        System.out.println(candy(ratings));
    }
}
