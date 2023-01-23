package com.company.xx.TOP100.T2.两数相加;

import com.company.xx.剑指offer.ListNode;
import com.company.xx.剑指offer.ListNodeUtil;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        int nextV = 0;
        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val + nextV;
            if (value < 10) {
                cur.next = new ListNode(value);
                nextV = 0;
            } else {
                value %= 10;
                cur.next = new ListNode(value);
                nextV = 1;
            }
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            if (nextV == 0) {
                cur.next = l1;
                return res.next;
            } else {
                int value = l1.val + nextV;
                if (value < 10) {
                    cur.next = new ListNode(value);
                    cur.next.next = l1.next;
                    return res.next;
                } else {
                    value %= 10;
                    nextV = 1;
                    cur.next = new ListNode(value);
                    l1 = l1.next;
                    cur = cur.next;
                }
            }
        }

        while (l2 != null) {
            if (nextV == 0) {
                cur.next = l2;
                return res.next;
            } else {
                int value = l2.val + nextV;
                if (value < 10) {
                    cur.next = new ListNode(value);
                    cur.next.next = l2.next;
                    return res.next;
                } else {
                    value %= 10;
                    nextV = 1;
                    cur.next = new ListNode(value);
                    l2 = l2.next;
                    cur = cur.next;
                }
            }
        }
        if (nextV == 1) {
            cur.next = new ListNode(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode L1 = ListNodeUtil.getLinkList(new int[]{8, 6});
        ListNode L2 = ListNodeUtil.getLinkList(new int[]{6, 4, 8});
        new Solution().addTwoNumbers(L1, L2);
    }
}
