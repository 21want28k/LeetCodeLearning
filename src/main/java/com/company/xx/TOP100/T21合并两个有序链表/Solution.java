package com.company.xx.TOP100.T21合并两个有序链表;

import com.company.xx.剑指offer.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode myHead = new ListNode(-1);
        myHead.next = list1;
        ListNode curL1 = list1, curL2 = list2, cur = myHead;
        while (curL1 != null || curL2 != null) {
            if (curL1 == null) {
                cur.next = curL2;
                break;
            }
            if (curL2 == null) {
                cur.next = curL1;
                break;
            }
            if (curL2.val > curL1.val) {
                cur.next = curL1;
                cur = cur.next;
                curL1 = curL1.next;
            } else {
                cur.next = curL2;
                cur = cur.next;
                curL2 = curL2.next;
            }
        }
        return myHead.next;
    }
}
