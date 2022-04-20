package com.company.xx.other.T148排序链表;

import com.company.xx.utils.SinglyLinkedListUtils;
import com.company.xx.剑指offer.ListNode;

import java.util.List;

public class Solution {

    /**
     * if the length of the list is odd, slow is mid;
     * if the length of the list is even, there will be two middle nodes. return the first
     * @param head
     * @return
     */
    ListNode findMid(ListNode head) {
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * if the length of the list is odd, slow is mid;
     * if the length of the list is even, there will be two middle nodes. return the second
     * @param head
     * @return
     */
    ListNode findMid2(ListNode head, ListNode tail) {
        ListNode fast = head, slow = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
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
        // head= [head->...mid->null] head2 = [mid.next ->...->null]
        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        // disconnect the head and head2
        mid.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(head2);
        return merge(l1, l2);
    }

    public ListNode sortList2(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head == tail) {
            head.next = null;
            return head;
        }
        ListNode mid = findMid2(head, tail);
        ListNode l1 = sortList2(head, mid);
        ListNode l2 = sortList2(mid.next, tail);
        return merge(l1, l2);
    }

    public ListNode sortList3(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList3(head, mid);
        ListNode list2 = sortList3(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

//    public ListNode sortList(ListNode head) {
//        return sortList(head);
//    }

    public static void main(String[] args) {
        int[] values = {4, 2, 1, 3};
        ListNode head = SinglyLinkedListUtils.arrayToList(values);
//        ListNode head1 = new Solution().sortList(head);
        ListNode mid1 = new Solution().findMid(head);
        ListNode mid2 = new Solution().findMid2(head, null);
    }
}
