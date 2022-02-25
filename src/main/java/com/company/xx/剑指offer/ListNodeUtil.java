package com.company.xx.剑指offer;

public class ListNodeUtil {
    public static ListNode getLinkList(int[] nodeValues) {
        ListNode head = null;
        ListNode cur = null;
        for (int i = 0; i < nodeValues.length; i++) {
            if (head == null) {
                head = new ListNode(nodeValues[0]);
                cur = head;
            } else {
                cur.next = new ListNode(nodeValues[i]);
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = getLinkList(new int[]{1, 2, 3, 4});
    }
}
