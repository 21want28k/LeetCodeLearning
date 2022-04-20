package com.company.xx.eightSortAlgorithm;

import com.company.xx.utils.MyArrayUtil;
import com.company.xx.utils.SinglyLinkedListUtils;
import com.company.xx.剑指offer.ListNode;

import java.util.Arrays;
import java.util.List;

public class QuickSort {

    public int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] > pivot) { // 从右开始找到第一个比pivot值小的数
                high--;
            }
            nums[low] = nums[high]; // 因为nums[low]的值已经被保存在pivot中了，所以直接放进nums[low]上
            while (low < high && nums[low] < pivot) { // 从左开始找到第一个比pivot值大的数
                low++;
            }
            nums[high] = nums[low]; // 同理
        }
        nums[low] = pivot; // 最后low == high也就是pivot该放的位置
        return low;
    }

    public int partition2(int[] nums, int low, int high) {
        int pivot = high;
        int p = low; // p代表比nums[pivot]小的数应该呆的位置
        for (int i = low; i < high; i++) {
            if (nums[i] <= nums[pivot]) {
                swap(nums, i, p);
                p++;
            }
        }
        // 最后的p指向第一个比nums[pivot]大的数，所以直接交换就行
        swap(nums, p, pivot);
        return p;
    }

    public int partition3(int[] nums, int low, int high) {
        int pivot = low;
        int p = low; // p代表比nums[pivot]小的数应该呆的位置
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] <= nums[pivot]) {
                p++;
                swap(nums, i, p);
            }
        }
        // 最后的p指向最后一个比nums[pivot]小的数，所以直接交换就行
        swap(nums, p, pivot);
        return p;
    }

    // 两种方法的区别就在于pivot选择的问题，如果一开始是在最右边，那么最后交换的一定是一个比nums[pivot]大的数，这样大的数才能到右侧；
    // 如果一开始pivot选在最左边，那么一定最后一定是一个比nums[pivot]还小的数交换。这就是为什么一个是先交换再p++，一个是先p++再交换的原因

    public void quickSort(int[] nums, int low, int high) {
        // 为什么low<high就可以了？因为low < high代表至少两个元素，如果只是一个元素就不用继续划分了
        if (low < high) {
            int pivot = partition3(nums, low, high);
            quickSort(nums, low, pivot - 1); // [low, pivot-1]是一个分区
            quickSort(nums, pivot + 1, high); // [pivot+1, high]是另一个分区
        }
    }

    public void sortLinkedList(ListNode head) {
        quickSort(head, null);
    }

    public void quickSort(ListNode head, ListNode tail) {
        if (head == tail) return;
        ListNode p = partition(head, tail);
        quickSort(head, p);
        quickSort(p.next, tail);
    }

    private ListNode partition(ListNode head, ListNode tail) {
        ListNode pivot = head;
        ListNode cur = head.next;
        ListNode p = pivot;
        while (cur != tail) {
            if (cur.val < pivot.val) {
                p = p.next;
                swap(cur, p);
            }
            cur = cur.next;
        }

        swap(p, pivot);
        return p;
    }

    public void swap(ListNode a, ListNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    public ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p_head = head.next;
        ListNode small = new ListNode(0);
        ListNode hSmall = small;

        ListNode large = new ListNode(0);
        ListNode hLarge = large;

        while (p_head != null) {
            if (p_head.val < head.val) {
                small.next = p_head;
                small = small.next;
            } else {
                large.next = p_head;
                large = large.next;
            }
            p_head = p_head.next;
        }

        large.next = null;
        small.next = head;
        head.next = null;

        small = quickSort(hSmall.next);
        large = quickSort(hLarge.next);
        head.next = large;
        return small;
    }

    public ListNode quickSort2(ListNode head, ListNode tail) {
        if (head == tail || head.next == tail) {
            return head;
        }

        ListNode p = head.next;
        ListNode lHead = head;
        ListNode rTail = head;
        while (p != tail) {
            ListNode next = p.next;
            if (p.val < head.val) {
                p.next = lHead;
                lHead = p;
            } else {
                rTail.next = p;
                rTail = p;
            }
            p = next;
        }
        // 去掉rtail后面多余的部分
        rTail.next = tail;

        ListNode res = quickSort2(lHead, head);
        head.next = quickSort2(head.next, tail);
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {10, 6, 3, 8, 33, 27, 66, 9, 7, 88};
//        new QuickSort().quickSort(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));

        int[] nums = {10, 6, 3};
        ListNode head = SinglyLinkedListUtils.arrayToList(nums);
//        new QuickSort().sortLinkedList(head);
        ListNode list = new QuickSort().quickSort2(head,null);
        SinglyLinkedListUtils.print(list);
    }
}
