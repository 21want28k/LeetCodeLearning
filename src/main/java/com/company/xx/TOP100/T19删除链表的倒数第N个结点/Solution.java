package com.company.xx.TOP100.T19删除链表的倒数第N个结点;

import com.company.xx.剑指offer.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (slow == head) {
            head = head.next;
            return head;
        }
        pre.next = slow.next;
        return head;
    }
}
