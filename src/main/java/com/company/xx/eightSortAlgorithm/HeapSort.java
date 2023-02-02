package com.company.xx.eightSortAlgorithm;

import com.company.xx.array.T347_Top_K_Frequent_Elements.Solution3;

import java.util.Arrays;

public class HeapSort {
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

//    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 4, 5, 6};
//        Solution3.Heap heap = new Solution3().new Heap();
////        heap.num = nums;
////        heap.length = nums.length - 1;
//        heap.num = new int[10000];
//        for (int i = 0; i < nums.length; i++) {
//            heap.add(nums[i]);
//        }
//        for (int i = 0; i < 5; i++) {
//            System.out.println(heap.delete(0));
//        }
//        System.out.println(Arrays.toString(heap.num));
//    }

    int length; // [0, length] 数组的有效范围,注意length是索引 有效长度 和nums.length不一样
    int[] nums;

    /**
     * adjust from up to down
     *
     * @param i      the index of the value to be adjusted
     * @param length inorder to record the length of the part of the heap to be sorted 为了记录待排堆的部分的长度
     *               After swapping the top and the bottom of the heap, the length of the heap will be reduced by one.在交换堆顶和堆底之后，待排堆的长度会减少1
     */
    public void adjustDown(int i, int length) {
        int father = nums[i]; // 先把被调整的节点单独抓出来

        for (int leftChild = 2 * i + 1; leftChild <= length; leftChild = 2 * i + 1) {
            int rightChild = leftChild + 1;
            int swappedChild = leftChild;


            // choose the bigger from left and right
            if (rightChild <= length && nums[rightChild] > nums[leftChild]) {
                swappedChild = rightChild;
            }

            // if bigger than father，这里没有进行交换操作，但是和交换意义是一样的，好处是省掉了操作，但是增加了代码阅读，举个例子，或者调试下代码就知道它在做什么了
            // 这里的father始终指向的是最初被调整的节点，如果之前做了交换，这里把father写成num[i]就是错误的，还是那句话，调试一下就知道了。
            if (nums[swappedChild] > father) {
                nums[i] = nums[swappedChild]; // 将孩子节点的值填入父节点值
                i = swappedChild; // 把孩子节点作为下一次被调整的对象
            } else {
                break;
            }

        }
        nums[i] = father; // 将被调整的节点放入最终位置上
    }

    /**
     * adjust from up to down
     *
     * @param i the index of the value to be adjusted
     */
    public void adjustDown2(int i, int length) {

        for (int leftChild = 2 * i + 1; leftChild <= length; leftChild = 2 * i + 1) {
            int rightChild = leftChild + 1;
            int swappedChild = leftChild;

            // choose the bigger from left and right
            if (rightChild < length && nums[rightChild] > nums[leftChild]) {
                swappedChild = rightChild;
            }

            if (nums[swappedChild] > nums[i]) {
                swap(nums, swappedChild, i); // 交换孩子节点和父节点
                i = swappedChild; // 把孩子节点作为下一次被调整的对象
            } else {
                break;
            }
        }
    }

    /**
     * adjust from down to up
     *
     * @param i the index of the valueto be adjusted
     */
    public void adjustUp(int i) {
        int temp = nums[i];


        // i 是需要被调整的节点，先计算出父节点的索引，当父节点索引>=0 并且 记住，被调整的节点是堆顶的时候不用调整了，不加会无限循环
        // 思路和从上下下调整差不多.
        for (int father = (i - 1) / 2; father >= 0 && i != 0; father = (i - 1) / 2) {
            if (nums[father] > temp) {
                nums[i] = nums[father];
                i = father;

            } else {
                break;
            }
        }
        nums[i] = temp;
    }

    public void build() {
        // create the heap
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustDown(i, length);
        }
    }

    public void sort() {
        // swap the top and the bottom to sort
        for (int i = length; i >= 0; i--) {
            swap(nums, 0, i);
            adjustDown(0, i - 1);
        }

    }

    public void insertValue(int value) {
        length++;
        nums[length] = value;
        adjustUp(length);
    }

    public void delete(int index) {
        if (index > length) {
            return;
        }
        if (index == length) {
            length--;
        } else  {
            nums[index] = nums[length];
            length--;
            adjustDown(index, length);
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = {4, 6, 8, 5, 9, -1, -1};
        heapSort.nums = nums;
        heapSort.length = 4;
        heapSort.build();
        heapSort.sort();
        heapSort.insertValue(3);
        heapSort.delete(0);
    }
}
