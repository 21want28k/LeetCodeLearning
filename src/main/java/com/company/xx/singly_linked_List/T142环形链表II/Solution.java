package com.company.xx.singly_linked_List.T142环形链表II;

import com.company.xx.剑指offer.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            if (fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode start = head;
                while (start != slow){
                    start = start.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }


}
