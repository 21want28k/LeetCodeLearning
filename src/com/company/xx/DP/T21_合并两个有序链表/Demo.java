package com.company.xx.DP.T21_合并两个有序链表;

public class Demo {

    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode l2 = new ListNode(0);
        mergeTwoLists(l1, l2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode head = null;
        ListNode cur = null;
        while (p != null && q != null) {
            ListNode small = null;
            if (p.val < q.val) {
                small = p;
                p = p.next;
            } else {
                small = q;
                q = q.next;
            }
            if (head == null) {
                head = small;
                cur = head;
            } else {
                cur.next = small;
                cur = cur.next;
            }
        }

        ListNode r = q == null ? p : q;
        while (r != null) {
            if (head == null) {
                head = r;
                cur = head;
            } else {
                cur.next = r;
                cur = cur.next;
            }
            r = r.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}