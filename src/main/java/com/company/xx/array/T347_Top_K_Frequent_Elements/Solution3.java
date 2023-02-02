package com.company.xx.array.T347_Top_K_Frequent_Elements;

import java.util.Arrays;

// https://www.cnblogs.com/CherishFX/p/4643940.html
public class Solution3 {
    class Heap {
        int[] num;
        int length; // length代表num数组最后一个index，是包含的，一般的length是不包含的

        public void swap(int a, int b) {
            int temp = num[a];
            num[a] = num[b];
            num[b] = temp;
        }

        // 从当前节点往下调整
        public void adjustDown(int i, int length) {
            // i一直代表需要被调整的那个节点
            while (i < length) {
                int leftChild = 2 * i + 1;
                if (leftChild > length) {
                    return;
                }
                int swappedChild = leftChild;
                int rightChild = leftChild + 1;
                if (rightChild <= length) {
                    if (num[rightChild] > num[leftChild]) {
                        swappedChild = rightChild;
                    }
                }
                if (num[i] < num[swappedChild]) {
                    swap(i, swappedChild);
                    i = swappedChild; // 移动到孩子节点继续调整
                } else {
                    return;
                }
            }

        }

        // 从当前节点往上调整
        public void adjustUp(int i) {
            while (i > 0) {
                int father = (i - 1) / 2;
                if (num[father] >= num[i]) {
                    return;
                }
                swap(father, i);
                i = father;
            }
        }

        public void add(int number) {
            num[++length] = number;
            adjustUp(length);
        }

        public int delete(int index) {
            int res = -1;
            if (index > length) {
                return res;
            }

            if (length == index) {
                res = num[length];
                length--;
            } else {
                swap(index, length);
                res = num[length];
                length--;
                adjustDown(index, length);
            }
            return res;
        }

        public void build() {
            for (int i = (length - 1) / 2; i >= 0; i--) {
                adjustDown(i, length);
            }
        }

        public void sort() {
            build();
            System.out.println(Arrays.toString(this.num));
            for (int i = length; i >= 0; i--) {
                swap(0, i);
                adjustDown(0, i - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 5, 6};
        Heap heap = new Solution3().new Heap();
//        heap.num = nums;
//        heap.length = nums.length - 1;
        heap.num = new int[10000];
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(heap.delete(0));
        }
        System.out.println(Arrays.toString(heap.num));
    }
}
