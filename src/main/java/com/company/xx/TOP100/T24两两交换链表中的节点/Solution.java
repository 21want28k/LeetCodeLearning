package com.company.xx.TOP100.T24两两交换链表中的节点;

import com.company.xx.剑指offer.ListNode;
import com.company.xx.剑指offer.ListNodeUtil;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode myhead = new ListNode(-1);
        myhead.next = head;
        ListNode first = head, second = head.next, pre = myhead;
        while (second != null) {
            pre.next = second;
            first.next = second.next;
            second.next = first;

            pre = first;
            first = first.next;
            if (first == null){
                return myhead.next;
            }
            second = first.next;
            if (second == null) {
                return myhead.next;
            }
        }
        return myhead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.getLinkList(new int[]{1, 2, 3, 4});
        new Solution().swapPairs(head);
    }
}
