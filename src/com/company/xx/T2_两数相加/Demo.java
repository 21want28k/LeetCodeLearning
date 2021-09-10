package com.company.xx.T2_两数相加;

public class Demo {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
//        ListNode l1 = new ListNode(3);
//        l1.next = new ListNode(7);
//
//        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(2);

        addTwoNumbers(l1, l2);
    }

    // 逆序的时候，个位是链表头部
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode head = null;
        ListNode r = null;
        int jin = 0;
        while (p != null && q != null) {
            int sum = p.val + q.val + jin;
            int yu = 0;
            if (sum >= 10) {
                yu = sum % 10;
                jin = 1;
            } else {
                yu = sum;
                jin = 0;
            }

            ListNode node = new ListNode(yu);
            if (head == null) {
                head = node;
                r = head;
            } else {
                // 尾插法
                r.next = node;
                r = node;
            }
            p = p.next;
            q = q.next;
        }

        // 两个链表可能不一样长
        ListNode cur = q == null ? p : q;
        while (cur != null) {
            int sum = jin + cur.val;
            int yu;
            if (sum >= 10) {
                jin = 1;
                yu = sum % 10;
            }else {
                yu = sum;
                jin = 0;
            }
            // 尾插法
            ListNode node = new ListNode(yu);
            r.next = node;
            r = node;
            cur = cur.next;
        }

        // 有一种特殊的情况，一直进位，最后一个数加完了之后还需要进1位，
        // 因为不进位的时候，进位标志会恢复到0，当代码走完的时候，如果进位标记是1，说明最后一个还有一个节点，需要加上
        if (jin == 1) {
            ListNode node = new ListNode(jin);
            r.next = node;
            r = node;
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