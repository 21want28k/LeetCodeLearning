package com.company.xx.other.T148排序链表;

import com.company.xx.utils.SinglyLinkedListUtils;
import com.company.xx.剑指offer.ListNode;

import java.util.List;

public class Solution {

    ListNode findMid(ListNode head) {
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return head.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(head2);
        return merge(l1, l2);
    }

//    public ListNode sortList(ListNode head) {
//        return sortList(head);
//    }

    public static void main(String[] args) {
        int[] values = {4, 2, 1, 3};
        ListNode head = SinglyLinkedListUtils.arrayToList(values);
        ListNode head1 = new Solution().sortList(head);
    }
}
