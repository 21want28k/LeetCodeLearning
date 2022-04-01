package com.company.xx.utils;

import com.company.xx.剑指offer.ListNode;

import java.util.List;

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

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        arrayToList(array);
    }
}
