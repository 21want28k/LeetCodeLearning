package com.company.xx.utils;

import com.company.xx.剑指offer.ListNode;

public class SinglyLinkedListUtils {

    /**
     * 不带头结点的单链表
     *
     * @param array
     * @return
     */
    public static ListNode arrayToList(int[] array) {
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        for (int value : array) {
            temp.next = new ListNode(value);
            temp = temp.next;
        }
        return head.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        ListNode head = arrayToList(array);
        print(head);
    }
}
