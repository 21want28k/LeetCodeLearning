package com.company.xx.singly_linked_List.T160链表相交;

import com.company.xx.剑指offer.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0, sizeB = 0;
        ListNode pointA = headA, pointB = headB;
        while (pointA != null) {
            sizeA++;
            pointA = pointA.next;
        }
        while (pointB != null) {
            sizeB++;
            pointB = pointB.next;
        }
        while (sizeA > sizeB) {
            headA = headA.next;
            sizeA--;
        }
        while (sizeB > sizeA) {
            headB = headB.next;
            sizeB--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
