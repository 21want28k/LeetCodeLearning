package com.company.xx.eightSortAlgorithm;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 6, 3, 8, 33, 27, 66, 9, 7, 88};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        //控制增量,增量为1的时候为最后一趟
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //从i开始的好处就是，把i作为待插入的数字，因为每个组里面的第一个数字自己就是有序的。所以不用从0开始。
            // j++ 而不是j+=i,是因为加入每间隔x个是一组，这里不是一组一组插入排序，而是所有的组同时进行插入排序。
            for (int j = i; j < arr.length; j++) {
                //k是已排序好的最后一个数字,j是待插入的数字
                int k = j - i;
                int temp = arr[j];
                while (k >= 0 && temp < arr[k]) {
                    arr[k+i] = arr[k];
                    k -= i;
                }
                arr[k + i] = temp;
            }
        }
    }

}
